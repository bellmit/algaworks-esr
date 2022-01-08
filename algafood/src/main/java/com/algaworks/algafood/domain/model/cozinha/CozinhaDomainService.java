package com.algaworks.algafood.domain.model.cozinha;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CozinhaDomainService {

    private CozinhaRepository cozinhaRepository;

    public List<Cozinha> listar() {
        return cozinhaRepository.listar();
    }

    public void adicionar(Cozinha cozinha) {
        if(cozinhaRepository.existeCozinhaComNome(cozinha.getNome())) {
            throw new EntidadeEmUsoException("Ja existe um cozinha cadastrada com o nome: " + cozinha.getNome());
        }

        this.cozinhaRepository.adicionar(cozinha);
    }

    public void atualizar(Cozinha cozinha) {

        if(cozinhaRepository.existeCozinhaComNomeComIdDiferente(cozinha.getNome(), cozinha.getId())) {
            throw new EntidadeEmUsoException("Ja existe um cozinha cadastrada com o nome: " + cozinha.getNome());
        }

        this.cozinhaRepository.atualizar(cozinha);
    }

    public Cozinha buscar(String id) {
        return cozinhaRepository.buscar(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Nao foi possivel encontrar uma cozinha de id: " + id
                ));
    }

    public void remover(Cozinha cozinha) {
        cozinhaRepository.remover(cozinha);
    }
}
