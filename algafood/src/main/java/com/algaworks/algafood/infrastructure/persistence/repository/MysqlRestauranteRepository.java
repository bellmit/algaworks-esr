package com.algaworks.algafood.infrastructure.persistence.repository;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.infrastructure.persistence.model.RestauranteModel;
import com.algaworks.algafood.infrastructure.persistence.service.RestauranteTranslator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
    public Optional<Restaurante> buscar(UUID id) {
        return manager.createQuery("SELECT r FROM RestauranteModel r WHERE r.id = ?1", RestauranteModel.class)
                .setParameter(1, id)
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
                .setParameter(2, restaurante.getId())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void remover(Restaurante restaurante) {
        manager.createQuery("DELETE FROM RestauranteModel r WHERE r.id = ?1")
                .setParameter(1, restaurante.getId())
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
    public boolean existeRestauranteComNomeComIdDiferente(String nome, UUID id) {
        return manager.createQuery(
                        "select case when count(r)> 0 then true else false " +
                                "end from RestauranteModel r where lower(r.nome) like lower(?1) " +
                                "and r.id <> ?2", Boolean.class)
                .setParameter(1, nome)
                .setParameter(2, id)
                .getSingleResult();
    }

    @Override
    public boolean existeRestauranteComCozinhaId(UUID id) {
        return manager.createQuery(
                        "select case when count(r)> 0 then true else false " +
                                "end from RestauranteModel r where r.cozinha.id = ?1", Boolean.class)
                .setParameter(1, id)
                .getSingleResult();
    }


}
