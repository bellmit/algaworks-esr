package com.algaworks.algafood.domain.model.cozinha;

import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Getter
@ToString
public class Cozinha {
    private String nome;

    public Cozinha(String nome) {

        if(!StringUtils.hasText(nome)) {
            throw new CozinhaException("Nome da cozinha nao pode ser null ou vazio");
        }
        this.nome = nome;
    }
}
