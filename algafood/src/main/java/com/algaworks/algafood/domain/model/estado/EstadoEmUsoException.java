package com.algaworks.algafood.domain.model.estado;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;

public class EstadoEmUsoException extends EntidadeEmUsoException {
    private static final String ESTADO_EM_USO_COM_NOME = "Ja existe um estado cadastrado com o nome: %s";
    private static final String ESTADO_EM_USO = "Nao e possivel remover um estado que esta sendo usado";

    public EstadoEmUsoException(String nome) {
        super(String.format(ESTADO_EM_USO_COM_NOME, nome));
    }

    public EstadoEmUsoException() {
        super(ESTADO_EM_USO);
    }
}
