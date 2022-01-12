package com.algaworks.algafood.domain.model.formapagamento;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;

public class FormaPagamentoEmUsoException extends EntidadeEmUsoException {
    private static final String FORMA_PAGAMENTO_EM_USO_COM_DESCRICAO = "Ja existe uma forma de pagamento cadastrado com a descricao: %s";
    private static final String FORMA_PAGAMENTO_EM_USO = "Nao e possivel remover uma forma de pagamento que esta sendo usada";

    public FormaPagamentoEmUsoException(String descricao) {
        super(String.format(FORMA_PAGAMENTO_EM_USO_COM_DESCRICAO, descricao));
    }

    public FormaPagamentoEmUsoException() {
        super(FORMA_PAGAMENTO_EM_USO);
    }
}
