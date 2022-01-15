package com.algaworks.algafood.domain.model.restaurante;

import com.algaworks.algafood.domain.model.cozinha.CozinhaId;
import com.algaworks.algafood.domain.model.formapagamento.FormaPagamentoId;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
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

    public RestauranteFactory adicionarFormasPagamentos(List<UUID> ids) {
        ids.forEach( id -> this.restaurante.adicionarFormaPagamento(new FormaPagamentoId(id)));
        return this;
    }

    public Restaurante build() {
        return this.restaurante;
    }
}
