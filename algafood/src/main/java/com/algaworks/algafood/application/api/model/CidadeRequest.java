package com.algaworks.algafood.application.api.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CidadeRequest {
    private String nome;
    private UUID estadoId;
}
