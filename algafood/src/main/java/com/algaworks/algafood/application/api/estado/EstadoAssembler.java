package com.algaworks.algafood.application.api.estado;

import com.algaworks.algafood.domain.model.estado.Estado;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstadoAssembler {

    public EstadoResponse toModel(Estado estado) {
        return EstadoResponse.builder()
                .id(estado.getEstadoId().getId())
                .nome(estado.getNome())
                .build();
    }
    public List<EstadoResponse> toCollectionModel(List<Estado> estados) {
        return estados.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
