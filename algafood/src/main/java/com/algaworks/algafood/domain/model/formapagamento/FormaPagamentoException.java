package com.algaworks.algafood.domain.model.formapagamento;

import com.algaworks.algafood.domain.exception.NegocioException;

public class FormaPagamentoException extends NegocioException {

    public FormaPagamentoException(String message) {
        super(message);
    }
}
