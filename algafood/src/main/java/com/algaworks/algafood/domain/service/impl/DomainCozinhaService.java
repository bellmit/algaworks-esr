package com.algaworks.algafood.domain.service.impl;

import com.algaworks.algafood.domain.exception.CozinhaEmUsoException;
import com.algaworks.algafood.domain.exception.CozinhaNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.CozinhaService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

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

        if(!cozinhaRepository.existeCozinhaComId(cozinha.getId())) {
           throw new CozinhaNaoEncontradaException(cozinha.getId());
        }

        if(cozinhaRepository.existeCozinhaComNomeComIdDiferente(cozinha.getNome(), cozinha.getId())) {
            throw new CozinhaEmUsoException(cozinha.getNome());
        }

        this.cozinhaRepository.atualizar(cozinha);
    }

    @Override
    public Cozinha buscar(UUID id) {
        return cozinhaRepository.buscar(id)
                .orElseThrow(() -> new CozinhaNaoEncontradaException(id));
    }

    @Override
    public void remover(UUID id) {
        if(!cozinhaRepository.existeCozinhaComId(id)) {
            throw new CozinhaNaoEncontradaException(id);
        }

        if(restauranteRepository.existeRestauranteComCozinhaId(id)) {
            throw new CozinhaEmUsoException();
        }

        cozinhaRepository.remover(id);
    }
}
