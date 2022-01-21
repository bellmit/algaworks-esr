package com.algaworks.algafood.domain.model.usuario;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;

import java.util.UUID;

public class UsuarioNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final String USUARIO_NAO_ENCONTRADO = "Nao foi possivel encontrar um usuario de id: %s";

    public UsuarioNaoEncontradoException(UUID id) {
        super(String.format(USUARIO_NAO_ENCONTRADO, id));
    }
}
