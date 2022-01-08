package com.algaworks.algafood.application.cozinha;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.cozinha.Cozinha;
import com.algaworks.algafood.domain.model.cozinha.CozinhaRepository;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class CozinhaApplicationService {

    private CozinhaRepository cozinhaRepository;

    public void adicionarCozinha(AdicionarCozinhaCommand command) {
        Cozinha cozinha = new Cozinha(UUID.randomUUID().toString(), command.getNome());
        cozinhaRepository.adicionar(cozinha);
    }

    public void atualizarCozinha(AtualizarCozinhaCommand command) {
        Cozinha cozinha = buscarOuFalhar(command.getId());

        cozinha.atualizarNome(command.getNome());
        cozinhaRepository.atualizar(cozinha);
    }

    public void removerCozinha(RemoverCozinhaCommand command) {
        Cozinha cozinha = buscarOuFalhar(command.getId());

        cozinhaRepository.remover(cozinha);
    }

    private Cozinha buscarOuFalhar(String id) {
        return cozinhaRepository.buscar(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Nao foi possivel encontrar uma cozinha de id: " + id
                ));
    }
}
