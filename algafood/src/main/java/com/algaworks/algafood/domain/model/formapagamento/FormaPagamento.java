package com.algaworks.algafood.domain.model.formapagamento;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Getter
@ToString
public class FormaPagamento {
    private FormaPagamentoId formaPagamentoId;
    private String descricao;

    public FormaPagamento(FormaPagamentoId formaPagamentoId, String descricao) {
       this.setFormaPagamentoId(formaPagamentoId);
       this.setDescricao(descricao);
    }

    private void setFormaPagamentoId(FormaPagamentoId formaPagamentoId) {
        if(formaPagamentoId == null) {
            throw new PropriedadeInvalidaException(FormaPagamento.class, "formaPagamentoId", "deve ser informado");
        }

        this.formaPagamentoId = formaPagamentoId;
    }

    private void setDescricao(String descricao) {
        if(!StringUtils.hasText(descricao)) {
            throw new PropriedadeInvalidaException(FormaPagamento.class, "formaPagamentoId", "deve ser informado");
        }

        this.descricao = descricao;
    }
}
