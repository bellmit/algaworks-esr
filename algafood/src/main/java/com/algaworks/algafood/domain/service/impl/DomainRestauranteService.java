package com.algaworks.algafood.domain.service.impl;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.RestauranteService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class DomainRestauranteService implements RestauranteService {

    private RestauranteRepository restauranteRepository;

    @Override
    public List<Restaurante> listar() {
        return restauranteRepository.listar();
    }

    @Override
    public void adicionar(Restaurante restaurante) {
        if(restauranteRepository.existeRestauranteComNome(restaurante.getNome())) {
            throw new EntidadeEmUsoException("Ja existe uma Restaurante cadastrado com o nome: " + restaurante.getNome());
        }

        this.restauranteRepository.adicionar(restaurante);
    }

    @Override
    public void atualizar(Restaurante restaurante) {

        if(restauranteRepository.existeRestauranteComNomeComIdDiferente(restaurante.getNome(), restaurante.getId())) {
            throw new EntidadeEmUsoException("Ja existe uma Restaurante cadastrado com o nome: " + restaurante.getNome());
        }

        this.restauranteRepository.atualizar(restaurante);
    }

    @Override
    public void remover(Restaurante restaurante) {
        restauranteRepository.remover(restaurante);
    }

    @Override
    public Restaurante buscar(UUID id) {
        return restauranteRepository.buscar(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Nao foi possivel encontrar um Restaurante de id: " + id
                ));
    }
}
