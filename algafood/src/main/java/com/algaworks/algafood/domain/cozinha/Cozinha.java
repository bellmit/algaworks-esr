package com.algaworks.algafood.domain.cozinha;

import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
public class Cozinha {
    private String nome;

    public Cozinha(String nome) {

        if(!StringUtils.hasText(nome)) {
            throw new CozinhaException("Nome da cozinha nao pode ser null ou vazio");
        }
        this.nome = nome;
    }
}
