package com.algaworks.algafood.application.api.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class EstadoResponse {
    private UUID id;
    private String nome;
}
