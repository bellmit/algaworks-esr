package com.algaworks.algafood.domain.model;

import com.algaworks.algafood.domain.exception.NegocioException;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Getter
@ToString
public class FormaPagamento {
    private UUID id;
    private String descricao;

    public FormaPagamento(UUID id, String descricao) {

        if(id == null) {
            throw new NegocioException("id da forma de pagamento nao pode ser null");
        }

        if(!StringUtils.hasText(descricao)) {
            throw new NegocioException("descricao da forma de pagamento nao pode ser null");
        }


        this.id = id;
        this.descricao = descricao;
    }
}
