package com.algaworks.algafood.domain.model.cidade;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;

import java.util.UUID;

public class CidadeNaoEncontradaException extends EntidadeNaoEncontradaException {

    private static final String CIDADE_NAO_ENCONTRADA = "Nao foi possivel encontrar uma cidade de id: %s";

    public CidadeNaoEncontradaException(UUID id) {
        super(String.format(CIDADE_NAO_ENCONTRADA, id));
    }
}
