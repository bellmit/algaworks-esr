package com.algaworks.algafood.application.api.assembler;

import com.algaworks.algafood.application.api.model.EnderecoResponse;
import com.algaworks.algafood.application.api.model.RestauranteResponse;
import com.algaworks.algafood.domain.model.endereco.Endereco;
import com.algaworks.algafood.domain.model.restaurante.Restaurante;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class RestauranteAssembler {

    private EnderecoAssembler enderecoAssembler;

    public RestauranteResponse toModel(Restaurante restaurante) {
        List<UUID> formasPagamentoId = restaurante.getFormaPagamentos().stream()
                .map(formaPagamentoId -> formaPagamentoId.getId())
                .collect(Collectors.toList());

        EnderecoResponse enderecoResponse = restaurante.getEndereco() != null ?
                enderecoAssembler.toModel(restaurante.getEndereco()) : EnderecoResponse.builder().build();

        return RestauranteResponse.builder()
                .id(restaurante.getRestauranteId().getId())
                .nome(restaurante.getNome())
                .taxaFrete(restaurante.getTaxaFrete())
                .cozinhaId(restaurante.getCozinhaId().getId())
                .formasPagamento(formasPagamentoId)
                .endereco(enderecoResponse)
                .build();
    }

    public List<RestauranteResponse> toCollectionModel(List<Restaurante> restaurantes) {
        return restaurantes.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
