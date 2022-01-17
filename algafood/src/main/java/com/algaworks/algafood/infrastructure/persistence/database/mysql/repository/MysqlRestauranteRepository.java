package com.algaworks.algafood.infrastructure.persistence.database.mysql.repository;

import com.algaworks.algafood.domain.model.cozinha.CozinhaId;
import com.algaworks.algafood.domain.model.restaurante.Restaurante;
import com.algaworks.algafood.domain.model.restaurante.RestauranteId;
import com.algaworks.algafood.domain.model.restaurante.RestauranteRepository;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.service.RestauranteTranslator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MysqlRestauranteRepository implements RestauranteRepository {

    private RestauranteTranslator restauranteTranslator;
    private SpringDataRestauranteRepository restauranteRepository;

    @Override
    public List<Restaurante> listar() {
        return restauranteRepository.findAll()
                .stream()
                .map(model -> restauranteTranslator.toRestauranteFromRestauranteModel(model))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void adicionar(Restaurante restaurante) {
        restauranteRepository.save(restauranteTranslator.toRestauranteModelFromRestaurante(restaurante));
    }

    @Override
    public Optional<Restaurante> buscar(RestauranteId restauranteId) {
        return restauranteRepository.findById(restauranteId.getId())
                .stream()
                .map(model -> restauranteTranslator.toRestauranteFromRestauranteModel(model))
                .findFirst();

    }

    @Override
    public Optional<Restaurante> buscarPeloNome(String nome) {
        return restauranteRepository.findByNome(nome)
                .stream()
                .map(model -> restauranteTranslator.toRestauranteFromRestauranteModel(model))
                .findFirst();
    }

    @Transactional
    @Override
    public void atualizar(Restaurante restaurante) {
        restauranteRepository.save(restauranteTranslator.toRestauranteModelFromRestaurante(restaurante));
    }

    @Transactional
    @Override
    public void remover(RestauranteId restauranteId) {
        restauranteRepository.deleteById(restauranteId.getId());
    }

    @Override
    public boolean existeRestauranteComNome(String nome) {
        return restauranteRepository.existsByNome(nome);
    }

    @Override
    public boolean existeRestauranteComNomeComIdDiferente(String nome, RestauranteId restauranteId) {
        return restauranteRepository.existsByNomeAndIdNot(nome, restauranteId.getId());
    }

    @Override
    public boolean existeRestauranteComCozinhaId(CozinhaId cozinhaId) {
        return restauranteRepository.existsByCozinha_Id(cozinhaId.getId());
    }

    @Override
    public boolean existeRestauranteComId(RestauranteId restauranteId) {
        return restauranteRepository.existsById(restauranteId.getId());
    }


}
