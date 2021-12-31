package com.algaworks.algafood.domain.cozinha;

import com.algaworks.algafood.domain.exception.NegocioException;

public class CozinhaException extends NegocioException {

    public CozinhaException(String message) {
        super(message);
    }
}
