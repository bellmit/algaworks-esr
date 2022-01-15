package com.algaworks.algafood.application.api.restaurante;

import com.algaworks.algafood.domain.model.restaurante.Restaurante;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class RestauranteAssembler {

    public RestauranteResponse toModel(Restaurante restaurante) {
        List<UUID> formasPagamentoId = restaurante.getFormaPagamentos().stream()
                .map(formaPagamentoId -> formaPagamentoId.getId())
                .collect(Collectors.toList());

        return RestauranteResponse.builder()
                .id(restaurante.getRestauranteId().getId())
                .nome(restaurante.getNome())
                .taxaFrete(restaurante.getTaxaFrete())
                .cozinhaId(restaurante.getCozinhaId().getId())
                .formasPagamento(formasPagamentoId)
                .build();
    }

    public List<RestauranteResponse> toCollectionModel(List<Restaurante> restaurantes) {
        return restaurantes.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
