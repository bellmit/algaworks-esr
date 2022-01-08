package com.algaworks.algafood.domain.model.permissao;

import com.algaworks.algafood.domain.model.formapagamento.FormaPagamentoException;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Getter
@ToString
public class Permissao {
    private String id;
    private String nome;
    private String descricao;

    public Permissao(String id, String nome, String descricao) {

        if(!StringUtils.hasText(id)) {
            throw new FormaPagamentoException("id da permissao nao pode ser null ou vazio");
        }

        if(!StringUtils.hasText(nome)) {
            throw new FormaPagamentoException("nome da permissao nao pode ser null ou vazio");
        }

        if(!StringUtils.hasText(descricao)) {
            throw new FormaPagamentoException("descricao da permissao nao pode ser null ou vazio");
        }

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
}
