package com.algaworks.algafood.domain.service.impl;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CozinhaService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class DomainCozinhaService implements CozinhaService {

    private CozinhaRepository cozinhaRepository;

    @Override
    public List<Cozinha> listar() {
        return cozinhaRepository.listar();
    }

    @Override
    public void adicionar(Cozinha cozinha) {
        if(cozinhaRepository.existeCozinhaComNome(cozinha.getNome())) {
            throw new EntidadeEmUsoException("Ja existe um cozinha cadastrada com o nome: " + cozinha.getNome());
        }

        this.cozinhaRepository.adicionar(cozinha);
    }

    @Override
    public void atualizar(Cozinha cozinha) {

        if(cozinhaRepository.existeCozinhaComNomeComIdDiferente(cozinha.getNome(), cozinha.getId())) {
            throw new EntidadeEmUsoException("Ja existe um cozinha cadastrada com o nome: " + cozinha.getNome());
        }

        this.cozinhaRepository.atualizar(cozinha);
    }

    @Override
    public Cozinha buscar(UUID id) {
        return cozinhaRepository.buscar(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Nao foi possivel encontrar uma cozinha de id: " + id
                ));
    }

    @Override
    public void remover(Cozinha cozinha) {
        cozinhaRepository.remover(cozinha);
    }
}
