package com.algaworks.algafood.application.api.estado;

import com.algaworks.algafood.domain.model.estado.Estado;
import com.algaworks.algafood.domain.model.estado.EstadoId;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EstadoDisassembler {

    public Estado toDomain(EstadoRequest request) {
        return new Estado(new EstadoId(UUID.randomUUID()), request.getNome());
    }

    public Estado toDomain(UUID id, EstadoRequest request) {
        return new Estado(new EstadoId(id), request.getNome());
    }

}
