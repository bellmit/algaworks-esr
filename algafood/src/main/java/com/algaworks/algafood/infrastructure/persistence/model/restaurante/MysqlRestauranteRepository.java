package com.algaworks.algafood.infrastructure.persistence.model.restaurante;

import com.algaworks.algafood.domain.model.cozinha.CozinhaId;
import com.algaworks.algafood.domain.model.restaurante.Restaurante;
import com.algaworks.algafood.domain.model.restaurante.RestauranteId;
import com.algaworks.algafood.domain.model.restaurante.RestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MysqlRestauranteRepository implements RestauranteRepository {

    private EntityManager manager;
    private RestauranteTranslator restauranteTranslator;


    @Override
    public List<Restaurante> listar() {
        return manager.createQuery("SELECT r FROM RestauranteModel r", RestauranteModel.class)
                .getResultList()
                .stream()
                .map(model -> restauranteTranslator.toRestauranteFromRestauranteModel(model))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void adicionar(Restaurante restaurante) {
        manager.merge(restauranteTranslator.toRestauranteModelFromRestaurante(restaurante));
    }

    @Override
    public Optional<Restaurante> buscar(RestauranteId restauranteId) {
        return manager.createQuery("SELECT r FROM RestauranteModel r WHERE r.id = ?1", RestauranteModel.class)
                .setParameter(1, restauranteId.getId())
                .getResultList()
                .stream()
                .map(model -> restauranteTranslator.toRestauranteFromRestauranteModel(model))
                .findFirst();

    }

    @Override
    public Optional<Restaurante> buscarPeloNome(String nome) {
        return manager.createQuery("SELECT r FROM RestauranteModel r WHERE r.nome = ?1", RestauranteModel.class)
                .setParameter(1, nome)
                .getResultList()
                .stream()
                .map(model -> restauranteTranslator.toRestauranteFromRestauranteModel(model))
                .findFirst();
    }

    @Transactional
    @Override
    public void atualizar(Restaurante restaurante) {
        manager.createQuery("UPDATE RestauranteModel r SET r.nome = ?1  WHERE r.id = ?2")
                .setParameter(1, restaurante.getNome())
                .setParameter(2, restaurante.getRestauranteId().getId())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void remover(RestauranteId restauranteId) {
        manager.createQuery("DELETE FROM RestauranteModel r WHERE r.id = ?1")
                .setParameter(1, restauranteId.getId())
                .executeUpdate();
    }

    @Override
    public boolean existeRestauranteComNome(String nome) {
        return manager.createQuery(
                        "select case when count(r)> 0 then true else false " +
                                "end from RestauranteModel r where lower(r.nome) like lower(?1)", Boolean.class)
                .setParameter(1, nome)
                .getSingleResult();
    }

    @Override
    public boolean existeRestauranteComNomeComIdDiferente(String nome, RestauranteId restauranteId) {
        return manager.createQuery(
                        "select case when count(r)> 0 then true else false " +
                                "end from RestauranteModel r where lower(r.nome) like lower(?1) " +
                                "and r.id <> ?2", Boolean.class)
                .setParameter(1, nome)
                .setParameter(2, restauranteId.getId())
                .getSingleResult();
    }

    @Override
    public boolean existeRestauranteComCozinhaId(CozinhaId cozinhaId) {
        return manager.createQuery(
                        "select case when count(r)> 0 then true else false " +
                                "end from RestauranteModel r where r.cozinha.id = ?1", Boolean.class)
                .setParameter(1, cozinhaId.getId())
                .getSingleResult();
    }

    @Override
    public boolean existeRestauranteComId(RestauranteId restauranteId) {
        return manager.createQuery(
                        "select case when count(r)> 0 then true else false " +
                                "end from RestauranteModel r where r.id = ?1", Boolean.class)
                .setParameter(1, restauranteId.getId())
                .getSingleResult();
    }


}
