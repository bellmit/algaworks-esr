package com.algaworks.algafood.domain.model.restaurante;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;

public class RestauranteEmUsoException extends EntidadeEmUsoException {
    private static final String RESTAURANTE_EM_USO_COM_NOME = "Ja existe um restaurante cadastrado com o nome: %s";
    private static final String RESTAURANTE_EM_USO = "Nao e possivel remover uma cozinha que esta sendo usada";

    public RestauranteEmUsoException(String nome) {
        super(String.format(RESTAURANTE_EM_USO_COM_NOME, nome));
    }

    public RestauranteEmUsoException() {
        super(RESTAURANTE_EM_USO);
    }
}
