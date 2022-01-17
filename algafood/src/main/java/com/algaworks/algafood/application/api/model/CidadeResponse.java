package com.algaworks.algafood.application.api.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CidadeResponse {
    private UUID id;
    private String nome;
    private UUID estadoId;
}
