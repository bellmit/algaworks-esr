package com.algaworks.algafood.application.api.restaurante;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class RestauranteResponse {
    private UUID id;
    private String nome;
    private BigDecimal taxaFrete;
    private UUID cozinhaId;
}
