package com.algaworks.algafood.application.api.restaurante;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class RestauranteInput {
    private String nome;
    private BigDecimal taxaFrete;
    private UUID cozinhaId;
}
