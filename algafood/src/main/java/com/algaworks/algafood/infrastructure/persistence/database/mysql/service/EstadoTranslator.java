package com.algaworks.algafood.infrastructure.persistence.database.mysql.service;

import com.algaworks.algafood.domain.model.estado.Estado;
import com.algaworks.algafood.domain.model.estado.EstadoId;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.EstadoModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EstadoTranslator {

    public EstadoModel toEstadoModelFromEstado(Estado estado) {
        EstadoModel estadoModel = new EstadoModel();
        estadoModel.setId(estado.getEstadoId().getId());
        estadoModel.setNome(estado.getNome());
        return estadoModel;
    }

    public Estado toEstadoFromEstadoModel(EstadoModel estadoModel) {
        return new Estado(new EstadoId(estadoModel.getId()), estadoModel.getNome());
    }
}
