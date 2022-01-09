package com.algaworks.algafood.infrastructure.persistence.service;

import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.infrastructure.persistence.model.FormaPagamentoModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

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
