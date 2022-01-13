package com.algaworks.algafood.domain.model.cidade;

import com.algaworks.algafood.domain.model.estado.EstadoId;

import java.util.UUID;

public class CidadeFactory {
    private Cidade cidade;

    private CidadeFactory(Cidade cidade) {
        this.cidade = cidade;
    }

    public static CidadeFactory builder(UUID cidadeId, String nome, UUID estadoId) {
        Cidade cidade = new Cidade(
                new CidadeId(cidadeId),
                nome,
                new EstadoId(estadoId)
        );
        return new CidadeFactory(cidade);
    }

    public Cidade build() {
        return this.cidade;
    }
}
