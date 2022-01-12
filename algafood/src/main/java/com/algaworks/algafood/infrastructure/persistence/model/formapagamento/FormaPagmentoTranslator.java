package com.algaworks.algafood.infrastructure.persistence.model.formapagamento;

import com.algaworks.algafood.domain.model.formapagamento.FormaPagamento;
import com.algaworks.algafood.infrastructure.persistence.model.formapagamento.FormaPagamentoModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FormaPagmentoTranslator {

    public FormaPagamentoModel toFormaPagamentoModelFromFormaPagamento(FormaPagamento formaPagamento) {
        FormaPagamentoModel formaPagamentoModel = new FormaPagamentoModel();
        formaPagamentoModel.setId(formaPagamento.getId());
        formaPagamentoModel.setDescricao(formaPagamento.getDescricao());
        return formaPagamentoModel;
    }

    public FormaPagamento toFormaPagamentoFromFormaPagamentoModel(FormaPagamentoModel formaPagamentoModel) {
        return new FormaPagamento(formaPagamentoModel.getId(), formaPagamentoModel.getDescricao());
    }
}
