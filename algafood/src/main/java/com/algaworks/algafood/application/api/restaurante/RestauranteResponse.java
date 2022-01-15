package com.algaworks.algafood.application.api.restaurante;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class RestauranteResponse {
    private UUID id;
    private String nome;
    private BigDecimal taxaFrete;
    private UUID cozinhaId;
    private List<UUID> formasPagamento;
}
