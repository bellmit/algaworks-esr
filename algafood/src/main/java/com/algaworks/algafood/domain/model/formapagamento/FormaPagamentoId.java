package com.algaworks.algafood.domain.model.formapagamento;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import lombok.Getter;

import java.util.UUID;

@Getter
public class FormaPagamentoId {
    private UUID id;

    public FormaPagamentoId(UUID id) {
        this.setId(id);
    }

    public void setId(UUID id) {
        if(id == null) {
            throw new PropriedadeInvalidaException(FormaPagamentoId.class, "id", "deve ser informado");
        }

        this.id = id;
    }
}
