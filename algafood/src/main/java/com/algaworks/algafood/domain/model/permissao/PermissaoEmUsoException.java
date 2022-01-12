package com.algaworks.algafood.domain.model.permissao;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;

public class PermissaoEmUsoException extends EntidadeEmUsoException {
    private static final String PERMISSAO_EM_USO_COM_NOME = "Ja existe uma permissao cadastrada com a descricao: %s";
    private static final String PERMISSAO_EM_USO = "Nao e possivel remover uma permissao que esta sendo usada";

    public PermissaoEmUsoException(String descricao) {
        super(String.format(PERMISSAO_EM_USO_COM_NOME, descricao));
    }

    public PermissaoEmUsoException() {
        super(PERMISSAO_EM_USO);
    }
}
