package com.algaworks.algafood.domain.model.estado;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import lombok.Getter;

import java.util.UUID;

@Getter
public class EstadoId {
    private UUID id;

    public EstadoId(UUID id) {
        this.setId(id);
    }

    private void setId(UUID id) {
        if(id == null) {
            throw new PropriedadeInvalidaException(EstadoId.class, "id", "deve ser informado");
        }

        this.id = id;
    }
}
