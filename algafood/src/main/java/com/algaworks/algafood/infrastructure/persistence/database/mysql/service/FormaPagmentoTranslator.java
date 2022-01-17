package com.algaworks.algafood.infrastructure.persistence.database.mysql.service;

import com.algaworks.algafood.domain.model.formapagamento.FormaPagamento;
import com.algaworks.algafood.domain.model.formapagamento.FormaPagamentoId;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.FormaPagamentoModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FormaPagmentoTranslator {

    public FormaPagamentoModel toFormaPagamentoModel(FormaPagamento formaPagamento) {
        FormaPagamentoModel formaPagamentoModel = new FormaPagamentoModel();
        formaPagamentoModel.setId(formaPagamento.getFormaPagamentoId().getId());
        formaPagamentoModel.setDescricao(formaPagamento.getDescricao());
        return formaPagamentoModel;
    }

    public Set<FormaPagamentoModel> toCollectionFormaPagamentoModel(Set<FormaPagamentoId> ids) {
        return ids.stream()
                .map(id -> {
                    FormaPagamentoModel model = new FormaPagamentoModel();
                    model.setId(id.getId());
                    return model;
                }).collect(Collectors.toSet());
    }

    public FormaPagamento toFormaPagamento(FormaPagamentoModel formaPagamentoModel) {
        return new FormaPagamento(
                new FormaPagamentoId(formaPagamentoModel.getId()),
                formaPagamentoModel.getDescricao()
        );
    }

    public List<FormaPagamento> toCollectionFormaPagamento(Set<FormaPagamentoModel> formaPagamentoModels) {
        return formaPagamentoModels.stream()
                .map(this::toFormaPagamento)
                .collect(Collectors.toList());
    }

}
