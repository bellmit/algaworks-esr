package com.algaworks.algafood.domain.model.cozinha;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;

import java.util.UUID;

public class CozinhaNaoEncontradaException extends EntidadeNaoEncontradaException {

    private static final String COZINHA_NAO_ENCONTRADA = "Nao foi possivel encontrar uma cozinha de id: %s";

    public CozinhaNaoEncontradaException(UUID id) {
        super(String.format(COZINHA_NAO_ENCONTRADA, id));
    }
}
