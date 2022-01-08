package com.algaworks.algafood.port.adapter.service;

import com.algaworks.algafood.domain.model.cidade.Cidade;
import com.algaworks.algafood.domain.model.estado.Estado;
import com.algaworks.algafood.port.adapter.persistence.model.EstadoModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class EstadoTranslator {

    public EstadoModel toEstadoModelFromEstado(Estado estado) {
        EstadoModel estadoModel = new EstadoModel();
        estadoModel.setId(UUID.fromString(estado.getId()));
        estadoModel.setNome(estado.getNome());
        return estadoModel;
    }

    public Estado toEstadoFromEstadoModel(EstadoModel cidadeModel) {
        return new Estado(cidadeModel.getId().toString(), cidadeModel.getNome());
    }
}
