package com.algaworks.algafood.domain.model.cozinha;

import com.algaworks.algafood.domain.model.restaurante.RestauranteRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DomainCozinhaService implements CozinhaService {

    private CozinhaRepository cozinhaRepository;
    private RestauranteRepository restauranteRepository;

    @Override
    public List<Cozinha> listar() {
        return cozinhaRepository.listar();
    }

    @Override
    public void adicionar(Cozinha cozinha) {
        if(cozinhaRepository.existeCozinhaComNome(cozinha.getNome())) {
            throw new CozinhaEmUsoException(cozinha.getNome());
        }

        this.cozinhaRepository.adicionar(cozinha);
    }

    @Override
    public void atualizar(Cozinha cozinha) {

        if(!cozinhaRepository.existeCozinhaComId(cozinha.getCozinhaId())) {
           throw new CozinhaNaoEncontradaException(cozinha.getCozinhaId().getId());
        }

        if(cozinhaRepository.existeCozinhaComNomeComIdDiferente(cozinha.getNome(), cozinha.getCozinhaId())) {
            throw new CozinhaEmUsoException(cozinha.getNome());
        }

        this.cozinhaRepository.atualizar(cozinha);
    }

    @Override
    public Cozinha buscar(CozinhaId cozinhaId) {
        return cozinhaRepository.buscar(cozinhaId)
                .orElseThrow(() -> new CozinhaNaoEncontradaException(cozinhaId.getId()));
    }

    @Override
    public void remover(CozinhaId cozinhaId) {
        if(!cozinhaRepository.existeCozinhaComId(cozinhaId)) {
            throw new CozinhaNaoEncontradaException(cozinhaId.getId());
        }

        if(restauranteRepository.existeRestauranteComCozinhaId(cozinhaId)) {
            throw new CozinhaEmUsoException();
        }

        cozinhaRepository.remover(cozinhaId);
    }
}
