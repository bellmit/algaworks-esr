package com.algaworks.algafood.domain.model.cozinha;

import com.algaworks.algafood.domain.exception.NegocioException;

public class CozinhaException extends NegocioException {

    public CozinhaException(String message) {
        super(message);
    }
}
