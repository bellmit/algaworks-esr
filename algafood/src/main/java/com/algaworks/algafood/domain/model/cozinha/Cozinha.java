package com.algaworks.algafood.domain.model.cozinha;

import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Getter
@ToString
public class Cozinha {
    private UUID codigo;
    private String nome;

    public Cozinha(UUID codigo, String nome) {
        validarCodigo(codigo);
        validarNomeCozinha(nome);

        this.codigo = codigo;
        this.nome = nome;
    }

    private void validarCodigo(UUID codigo) {
        if(codigo == null) {
            throw new CozinhaException("Codigo da cozinha nao pode ser null");
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
