package com.algaworks.algafood.domain.model.usuario;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import lombok.Getter;

import java.util.UUID;

@Getter
public class UsuarioId {
    private UUID id;

    public UsuarioId(UUID id) {
        this.setId(id);
    }

    public void setId(UUID id) {

        if(id == null) {
            throw new PropriedadeInvalidaException(UsuarioId.class, "id", "deve ser informado");
        }

        this.id = id;
    }
}
