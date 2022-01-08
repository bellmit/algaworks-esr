package com.algaworks.algafood.domain.model.permissao;

import com.algaworks.algafood.domain.exception.NegocioException;

public class PermissaoException extends NegocioException {

    public PermissaoException(String message) {
        super(message);
    }
}
