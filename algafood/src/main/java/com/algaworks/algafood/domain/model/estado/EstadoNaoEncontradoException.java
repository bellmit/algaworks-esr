package com.algaworks.algafood.domain.model.estado;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;

import java.util.UUID;

public class EstadoNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final String ESTADO_NAO_ENCONTRADO = "Nao foi possivel encontrar um estado de id: %s";

    public EstadoNaoEncontradoException(UUID id) {
        super(String.format(ESTADO_NAO_ENCONTRADO, id));
    }
}
