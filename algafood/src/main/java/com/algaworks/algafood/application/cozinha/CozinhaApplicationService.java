package com.algaworks.algafood.application.cozinha;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.cozinha.Cozinha;
import com.algaworks.algafood.domain.model.cozinha.CozinhaDomainService;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class CozinhaApplicationService {

    private CozinhaDomainService domainService;

    public void adicionarCozinha(AdicionarCozinhaCommand command) {
        Cozinha cozinha = new Cozinha(UUID.randomUUID().toString(), command.getNome());
        domainService.adicionar(cozinha);
    }

    public void atualizarCozinha(AtualizarCozinhaCommand command) {
        Cozinha cozinha = domainService.buscar(command.getId());
        cozinha.atualizarNome(command.getNome());
        domainService.adicionar(cozinha);
    }

    public void removerCozinha(RemoverCozinhaCommand command) {
        Cozinha cozinha = domainService.buscar(command.getId());
        domainService.remover(cozinha);
    }

}
