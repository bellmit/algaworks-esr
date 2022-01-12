package com.algaworks.algafood.domain.model.cidade;

import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.estado.Estado;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Getter
@ToString
public class Cidade {
    private UUID id;
    private String nome;
    private Estado estado;

    public Cidade(UUID id, String nome, Estado estado) {
        if(id == null) {
            throw new NegocioException("id da cidade nao pode ser null");
        }

        if(!StringUtils.hasText(nome)) {
            throw new NegocioException("nome da cidade nao pode ser null ou vazio ");
        }

        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }
}
