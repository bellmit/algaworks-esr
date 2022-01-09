package com.algaworks.algafood.infrastructure.persistence.service;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.infrastructure.persistence.model.EstadoModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class EstadoTranslator {

    public EstadoModel toEstadoModelFromEstado(Estado estado) {
        EstadoModel estadoModel = new EstadoModel();
        estadoModel.setId(estado.getId());
        estadoModel.setNome(estado.getNome());
        return estadoModel;
    }

    public Estado toEstadoFromEstadoModel(EstadoModel cidadeModel) {
        return new Estado(cidadeModel.getId(), cidadeModel.getNome());
    }
}
