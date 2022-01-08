package com.algaworks.algafood.port.adapter.service;

import com.algaworks.algafood.domain.model.cozinha.Cozinha;
import com.algaworks.algafood.domain.model.formapagamento.FormaPagamento;
import com.algaworks.algafood.port.adapter.persistence.model.CozinhaModel;
import com.algaworks.algafood.port.adapter.persistence.model.FormaPagamentoModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class FormaPagmentoTranslator {

    public FormaPagamentoModel toFormaPagamentoModelFromFormaPagamento(FormaPagamento formaPagamento) {
        FormaPagamentoModel formaPagamentoModel = new FormaPagamentoModel();
        formaPagamentoModel.setId(UUID.fromString(formaPagamento.getId()));
        formaPagamentoModel.setDescricao(formaPagamento.getDescricao());
        return formaPagamentoModel;
    }

    public FormaPagamento toFormaPagamentoFromFormaPagamentoModel(FormaPagamentoModel formaPagamentoModel) {
        return new FormaPagamento(formaPagamentoModel.getId().toString(), formaPagamentoModel.getDescricao());
    }
}
