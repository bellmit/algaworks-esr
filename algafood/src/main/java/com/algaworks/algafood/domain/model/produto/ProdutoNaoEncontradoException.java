package com.algaworks.algafood.domain.model.produto;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;

import java.util.UUID;

public class ProdutoNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final String PERMISSAO_NAO_ENCONTRADA = "Nao foi possivel encontrar um produto de id: %s";

    public ProdutoNaoEncontradoException(UUID id) {
        super(String.format(PERMISSAO_NAO_ENCONTRADA, id));
    }
}
