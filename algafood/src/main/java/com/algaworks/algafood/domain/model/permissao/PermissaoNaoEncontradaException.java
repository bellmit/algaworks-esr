package com.algaworks.algafood.domain.model.permissao;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;

import java.util.UUID;

public class PermissaoNaoEncontradaException extends EntidadeNaoEncontradaException {

    private static final String PERMISSAO_NAO_ENCONTRADA = "Nao foi possivel encontrar uma permissao de id: %s";

    public PermissaoNaoEncontradaException(UUID id) {
        super(String.format(PERMISSAO_NAO_ENCONTRADA, id));
    }
}
