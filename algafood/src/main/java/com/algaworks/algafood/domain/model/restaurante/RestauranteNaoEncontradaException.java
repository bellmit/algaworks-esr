package com.algaworks.algafood.domain.model.restaurante;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;

import java.util.UUID;

public class RestauranteNaoEncontradaException extends EntidadeNaoEncontradaException {

    private static final String RESTAURANTE_NAO_ENCONTRADA = "Nao foi possivel encontrar um restaurante de id: %s";

    public RestauranteNaoEncontradaException(UUID id) {
        super(String.format(RESTAURANTE_NAO_ENCONTRADA, id));
    }
}
