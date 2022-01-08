package com.algaworks.algafood.domain.model.cidade;

import com.algaworks.algafood.domain.model.estado.Estado;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Getter
@ToString
public class Cidade {
    private String id;
    private String nome;
    private Estado estado;

    public Cidade(String id, String nome, Estado estado) {

        if(!StringUtils.hasText(id)) {
            throw new CidadeException("id da cidade nao pode ser null");
        }

        if(!StringUtils.hasText(nome)) {
            throw new CidadeException("nome da cidade nao pode ser null");
        }

        if(estado == null) {
            throw new CidadeException("estado da cidade nao pode ser null");
        }

        this.id = id;
        this.nome = nome;
    }
}
