package com.algaworks.algafood.domain.model.estado;

import com.algaworks.algafood.domain.exception.NegocioException;

public class EstadoException extends NegocioException {

    public EstadoException(String message) {
        super(message);
    }
}
