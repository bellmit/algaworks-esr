package com.algaworks.algafood.domain.model.produto;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ProdutoId {
    private UUID id;

    public ProdutoId(UUID id) {
        this.setId(id);
    }

    public void setId(UUID id) {
        if (id == null) {
            throw new PropriedadeInvalidaException(ProdutoId.class, "id", "deve ser informado");
        }

        this.id = id;
    }
}
