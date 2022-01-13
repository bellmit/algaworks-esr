package com.algaworks.algafood.domain.model.formapagamento;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;

import java.util.UUID;

public class FormaPagamentoNaoEncontradaException extends EntidadeNaoEncontradaException {

    private static final String FORMA_PAGAMENTO_NAO_ENCONTRADA = "Nao foi possivel encontrar uma forma de pagamento de id: %s";

    public FormaPagamentoNaoEncontradaException(UUID id) {
        super(String.format(FORMA_PAGAMENTO_NAO_ENCONTRADA, id));
    }
}
