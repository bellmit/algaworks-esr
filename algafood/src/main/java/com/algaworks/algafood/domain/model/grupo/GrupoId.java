package com.algaworks.algafood.domain.model.grupo;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import lombok.Getter;

import java.util.UUID;

@Getter
public class GrupoId {
    private UUID id;

    public GrupoId(UUID id) {
        this.setId(id);
    }

    public void setId(UUID id) {
        if(id == null) {
            throw new PropriedadeInvalidaException(GrupoId.class, "id", "deve ser informado");
        }
        this.id = id;
    }
}
