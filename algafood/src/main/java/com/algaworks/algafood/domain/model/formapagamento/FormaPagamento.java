package com.algaworks.algafood.domain.model.formapagamento;

import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Getter
@ToString
public class FormaPagamento {
    private String id;
    private String descricao;

    public FormaPagamento(String id, String descricao) {

        if(!StringUtils.hasText(id)) {
            throw new FormaPagamentoException("id da forma de pagamento nao pode ser null");
        }

        if(!StringUtils.hasText(descricao)) {
            throw new FormaPagamentoException("descricao da forma de pagamento nao pode ser null");
        }


        this.id = id;
        this.descricao = descricao;
    }
}
