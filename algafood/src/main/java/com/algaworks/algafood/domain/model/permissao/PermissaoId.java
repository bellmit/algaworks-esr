package com.algaworks.algafood.domain.model.permissao;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import lombok.Getter;

import java.util.UUID;

@Getter
public class PermissaoId {
    private UUID id;

    public PermissaoId(UUID id) {
        this.setId(id);
    }

    private void setId(UUID id) {
        if(id == null) {
            throw new PropriedadeInvalidaException(PermissaoId.class, "id", "deve ser informado");
        }

        this.id = id;
    }
}
