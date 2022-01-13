package com.algaworks.algafood.domain.model.restaurante;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import lombok.Getter;

import java.util.UUID;

@Getter
public class RestauranteId {

    private UUID id;

    public RestauranteId(UUID id) {
        this.setId(id);
    }

    private void setId(UUID id) {

        if(id == null) {
            throw new PropriedadeInvalidaException(Restaurante.class, "id", "deve ser informado.");
        }

        this.id = id;
    }
}
