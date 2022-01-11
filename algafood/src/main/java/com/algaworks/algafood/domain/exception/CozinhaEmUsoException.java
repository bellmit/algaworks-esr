package com.algaworks.algafood.domain.exception;

import com.algaworks.algafood.domain.model.Cozinha;

import java.util.UUID;

public class CozinhaEmUsoException extends EntidadeEmUsoException{
    private static final String COZINHA_EM_USO_COM_NOME = "Ja existe um cozinha cadastrada com o nome: %s";
    private static final String COZINHA_EM_USO_COM_ID = "Ja existe um cozinha cadastrada com o id: %s";

    public CozinhaEmUsoException(String nome) {
        super(String.format(COZINHA_EM_USO_COM_NOME, nome));
    }

    public CozinhaEmUsoException(UUID id) {
        super(String.format(COZINHA_EM_USO_COM_ID, id));
    }
}
