package com.algaworks.algafood.application.api.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class RestauranteRequest {
    private String nome;
    private BigDecimal taxaFrete;
    private UUID cozinhaId;
}
