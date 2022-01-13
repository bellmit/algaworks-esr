package com.algaworks.algafood.domain.model.restaurante;

import com.algaworks.algafood.domain.model.cozinha.CozinhaId;

import java.math.BigDecimal;
import java.util.UUID;

public class RestauranteFactory {

    private Restaurante restaurante;

    private RestauranteFactory(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public static RestauranteFactory builder(UUID restauranteId, String nome, BigDecimal taxaFrete, UUID cidadeId) {
        Restaurante novoRestaurante = new Restaurante(
                new RestauranteId(restauranteId),
                nome,
                taxaFrete,
                new CozinhaId(cidadeId)
        );
        return new RestauranteFactory(novoRestaurante);
    }

    public Restaurante build() {
        return this.restaurante;
    }
}
