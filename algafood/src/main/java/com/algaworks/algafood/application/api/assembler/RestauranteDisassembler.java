package com.algaworks.algafood.application.api.assembler;

import com.algaworks.algafood.application.api.model.RestauranteRequest;
import com.algaworks.algafood.domain.model.cozinha.CozinhaId;
import com.algaworks.algafood.domain.model.restaurante.Restaurante;
import com.algaworks.algafood.domain.model.restaurante.RestauranteFactory;
import com.algaworks.algafood.domain.model.restaurante.RestauranteId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public Restaurante copyToDomain(RestauranteRequest restauranteRequest, Restaurante restaurante) {
        List<UUID> ids = restaurante.getFormaPagamentos()
                .stream()
                .map(formaPagamentoId -> formaPagamentoId.getId())
                .collect(Collectors.toList());

        return RestauranteFactory
                .builder(
                        restaurante.getRestauranteId().getId(),
                        restauranteRequest.getNome(),
                        restauranteRequest.getTaxaFrete(),
                        restauranteRequest.getCozinhaId(),
                        restaurante.getDataCadastro(),
                        restaurante.getDataAtualizacao()
                        )
                .adicionarFormasPagamento(ids)
                .adicionarEndereco(restaurante.getEndereco())
                .build();
    }

}
