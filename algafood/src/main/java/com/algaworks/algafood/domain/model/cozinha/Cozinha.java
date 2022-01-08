package com.algaworks.algafood.domain.model.cozinha;

import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Getter
@ToString
public class Cozinha {
    private String id;
    private String nome;

    public Cozinha(String id, String nome) {

        validarId(id);
        validarNomeCozinha(nome);

        this.id = id;
        this.nome = nome;
    }

    private void validarId(String id) {
        if(!StringUtils.hasText(id)) {
            throw new CozinhaException("id da cozinha nao pode ser null");
        }
    }

    private void validarNomeCozinha(String nome) {
        if (!StringUtils.hasText(nome)) {
            throw new CozinhaException("Nome da cozinha nao pode ser null ou vazio");
        }
    }

    public void atualizarNome(String nome) {
        validarNomeCozinha(nome);
        this.nome = nome;
    }


}
