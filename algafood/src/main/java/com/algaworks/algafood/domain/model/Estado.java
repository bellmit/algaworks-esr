package com.algaworks.algafood.domain.model;

import com.algaworks.algafood.domain.exception.NegocioException;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Getter
@ToString
public class Estado {
    private UUID id;
    private String nome;

    public Estado(UUID id, String nome) {

        if(id == null) {
            throw new NegocioException("id do estado nao pode ser null");
        }

        if(!StringUtils.hasText(nome)) {
            throw new NegocioException("nome do estado nao pode ser null");
        }

        this.id = id;
        this.nome = nome;
    }


}
