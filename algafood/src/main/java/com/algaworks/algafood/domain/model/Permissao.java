package com.algaworks.algafood.domain.model;

import com.algaworks.algafood.domain.exception.NegocioException;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Getter
@ToString
public class Permissao {
    private UUID id;
    private String nome;
    private String descricao;

    public Permissao(UUID id, String nome, String descricao) {

        if(id == null) {
            throw new NegocioException("id da permissao nao pode ser null ou vazio");
        }

        if(!StringUtils.hasText(nome)) {
            throw new NegocioException("nome da permissao nao pode ser null ou vazio");
        }

        if(!StringUtils.hasText(descricao)) {
            throw new NegocioException("descricao da permissao nao pode ser null ou vazio");
        }

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
}
