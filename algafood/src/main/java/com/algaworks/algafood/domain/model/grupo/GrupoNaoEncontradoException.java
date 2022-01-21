package com.algaworks.algafood.domain.model.grupo;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;

import java.util.UUID;

public class GrupoNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final String GRUPO_NAO_ENCONTRADO = "Nao foi possivel encontrar um grupo de id: %s";

    public GrupoNaoEncontradoException(UUID id) {
        super(String.format(GRUPO_NAO_ENCONTRADO, id));
    }
}
