package com.algaworks.algafood.domain.model.cozinha;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;

public class CozinhaEmUsoException extends EntidadeEmUsoException {
    private static final String COZINHA_EM_USO_COM_NOME = "Ja existe um cozinha cadastrada com o nome: %s";
    private static final String COZINHA_EM_USO = "Nao e possivel remover uma cozinha que esta sendo usada";

    public CozinhaEmUsoException(String nome) {
        super(String.format(COZINHA_EM_USO_COM_NOME, nome));
    }

    public CozinhaEmUsoException() {
        super(COZINHA_EM_USO);
    }
}
