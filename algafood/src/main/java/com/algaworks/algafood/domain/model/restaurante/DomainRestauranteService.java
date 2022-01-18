package com.algaworks.algafood.domain.model.restaurante;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import com.algaworks.algafood.domain.model.cozinha.CozinhaRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DomainRestauranteService implements RestauranteService {

    private RestauranteRepository restauranteRepository;
    private CozinhaRepository cozinhaRepository;

    @Override
    public List<Restaurante> listar() {
        return restauranteRepository.listar();
    }

    @Override
    public void adicionar(Restaurante restaurante) {
        if (restauranteRepository.existeRestauranteComNome(restaurante.getNome())) {
            throw new RestauranteEmUsoException(restaurante.getNome());
        }

        if (!cozinhaRepository.existeCozinhaComId(restaurante.getCozinhaId())) {
            throw new PropriedadeInvalidaException(Restaurante.class, "cozinhaId", "invalida");
        }

        this.restauranteRepository.adicionar(restaurante);
    }

    @Override
    public void atualizar(Restaurante restaurante) {

        if (!this.restauranteRepository.existeRestauranteComId(restaurante.getRestauranteId())) {
            throw new RestauranteNaoEncontradaException(restaurante.getRestauranteId().getId());
        }

        if (restauranteRepository.existeRestauranteComNomeComIdDiferente(
                restaurante.getNome(), restaurante.getRestauranteId())
        ) {
            throw new RestauranteEmUsoException(restaurante.getNome());
        }

        if (!cozinhaRepository.existeCozinhaComId(restaurante.getCozinhaId())) {
            throw new PropriedadeInvalidaException(Restaurante.class, "cozinhaId", "invalida");
        }

        restaurante.atualizarDataAtualizacao();
        this.restauranteRepository.atualizar(restaurante);
    }

    @Override
    public void remover(RestauranteId restauranteId) {

        if (!this.restauranteRepository.existeRestauranteComId(restauranteId)) {
            throw new RestauranteNaoEncontradaException(restauranteId.getId());
        }

        restauranteRepository.remover(restauranteId);
    }

    @Override
    public Restaurante buscar(RestauranteId restauranteId) {
        return restauranteRepository.buscar(restauranteId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Nao foi possivel encontrar um Restaurante de id: " + restauranteId.getId()
                ));
    }
}
