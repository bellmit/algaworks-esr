package com.algaworks.algafood.port.adapter.persistence.repository;

import com.algaworks.algafood.domain.model.restaurante.Restaurante;
import com.algaworks.algafood.domain.model.restaurante.RestauranteRepository;
import com.algaworks.algafood.port.adapter.persistence.model.RestauranteModel;
import com.algaworks.algafood.port.adapter.service.RestauranteTranslator;
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
        return manager.createQuery("SELECT c FROM RestauranteModel c", RestauranteModel.class)
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
    public Optional<Restaurante> buscar(String id) {
        return manager.createQuery("SELECT c FROM RestauranteModel c WHERE c.id = ?1", RestauranteModel.class)
                .setParameter(1, UUID.fromString(id))
                .getResultList()
                .stream()
                .map(model -> restauranteTranslator.toRestauranteFromRestauranteModel(model))
                .findFirst();

    }

    @Override
    public Optional<Restaurante> buscarPeloNome(String nome) {
        return manager.createQuery("SELECT c FROM RestauranteModel c WHERE c.nome = ?1", RestauranteModel.class)
                .setParameter(1, nome)
                .getResultList()
                .stream()
                .map(model -> restauranteTranslator.toRestauranteFromRestauranteModel(model))
                .findFirst();
    }

    @Transactional
    @Override
    public void atualizar(Restaurante restaurante) {
        manager.createQuery("UPDATE RestauranteModel c SET c.nome = ?1  WHERE c.id = ?2")
                .setParameter(1, restaurante.getNome())
                .setParameter(2, restaurante.getId())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void remover(Restaurante restaurante) {
        manager.createQuery("DELETE FROM RestauranteModel c WHERE c.id = ?1")
                .setParameter(1, UUID.fromString(restaurante.getId()))
                .executeUpdate();
    }


}
