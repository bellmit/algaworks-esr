package com.algaworks.algafood.domain.model.cidade;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CidadeId {
    private UUID id;

    public CidadeId(UUID id) {
        this.setId(id);
    }

    private void setId(UUID id) {
        if(id == null) {
            throw new PropriedadeInvalidaException(CidadeId.class, "id", "deve ser informado");
        }

        this.id = id;
    }
}
