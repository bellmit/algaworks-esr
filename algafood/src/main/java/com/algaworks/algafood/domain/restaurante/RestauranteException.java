package com.algaworks.algafood.domain.restaurante;

import com.algaworks.algafood.domain.exception.NegocioException;

public class RestauranteException extends NegocioException {
    public RestauranteException(String message) {
        super(message);
    }
}
