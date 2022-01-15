package com.algaworks.algafood.application.api.restaurante;

import com.algaworks.algafood.domain.model.cozinha.CozinhaId;
import com.algaworks.algafood.domain.model.restaurante.Restaurante;
import com.algaworks.algafood.domain.model.restaurante.RestauranteId;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RestauranteDisassembler {

    public Restaurante toDomain(RestauranteRequest restauranteRequest) {
        return this.toDomain(UUID.randomUUID(), restauranteRequest);
    }

    public Restaurante toDomain(UUID id, RestauranteRequest restauranteRequest) {
        return new Restaurante(
                new RestauranteId(id),
                restauranteRequest.getNome(),
                restauranteRequest.getTaxaFrete(),
                new CozinhaId(restauranteRequest.getCozinhaId())
        );
    }
}
