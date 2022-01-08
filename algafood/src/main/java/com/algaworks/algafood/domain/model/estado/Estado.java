package com.algaworks.algafood.domain.model.estado;

import com.algaworks.algafood.domain.model.cidade.CidadeException;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Getter
@ToString
public class Estado {
    private String id;
    private String nome;

    public Estado(String id, String nome) {

        if(!StringUtils.hasText(id)) {
            throw new CidadeException("id do estado nao pode ser null");
        }

        if(!StringUtils.hasText(nome)) {
            throw new CidadeException("nome do estado nao pode ser null");
        }

        this.id = id;
        this.nome = nome;
    }


}
