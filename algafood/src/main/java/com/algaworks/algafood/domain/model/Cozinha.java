package com.algaworks.algafood.domain.model;

import com.algaworks.algafood.domain.exception.NegocioException;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Getter
@ToString
public class Cozinha {
    private UUID id;
    private String nome;

    public Cozinha(UUID id, String nome) {

        if (!StringUtils.hasText(nome)) {
            throw new NegocioException("Nome da Cozinha nao pode ser null ou vazio");
        }

        this.id = id == null ? UUID.randomUUID() : id;
        this.nome = nome;
    }
}
