package com.algaworks.algafood.domain.model.cidade;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;

public class CidadeEmUsoException extends EntidadeEmUsoException {
    private static final String CIDADE_EM_USO_COM_NOME = "Ja existe uma cidade cadastrada com o nome: %s";
    private static final String CIDADE_EM_USO = "Nao e possivel remover uma cidade que esta sendo usada";

    public CidadeEmUsoException(String nome) {
        super(String.format(CIDADE_EM_USO_COM_NOME, nome));
    }

    public CidadeEmUsoException() {
        super(CIDADE_EM_USO);
    }
}
