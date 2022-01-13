package com.algaworks.algafood.domain.model.cozinha;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CozinhaId {
    private UUID id;

    public CozinhaId(UUID id) {
        this.setId(id);
    }

    private void setId(UUID id) {
        if(id == null) {
            throw new PropriedadeInvalidaException(Cozinha.class, "id", "deve ser informado.");
        }

        this.id = id;
    }
}
