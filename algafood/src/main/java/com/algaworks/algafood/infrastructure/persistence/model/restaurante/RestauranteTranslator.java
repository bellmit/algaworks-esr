package com.algaworks.algafood.infrastructure.persistence.model.restaurante;

import com.algaworks.algafood.domain.model.cozinha.CozinhaId;
import com.algaworks.algafood.domain.model.formapagamento.FormaPagamentoId;
import com.algaworks.algafood.domain.model.restaurante.Restaurante;
import com.algaworks.algafood.domain.model.restaurante.RestauranteFactory;
import com.algaworks.algafood.domain.model.restaurante.RestauranteId;
import com.algaworks.algafood.infrastructure.persistence.model.cozinha.CozinhaModel;
import com.algaworks.algafood.infrastructure.persistence.model.formapagamento.FormaPagmentoTranslator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class RestauranteTranslator {

    private FormaPagmentoTranslator formaPagmentoTranslator;

    public RestauranteModel toRestauranteModelFromRestaurante(Restaurante restaurante) {
        CozinhaModel cozinhaModel = new CozinhaModel();
        cozinhaModel.setId(restaurante.getCozinhaId().getId());

        RestauranteModel restauranteModel = new RestauranteModel();
        restauranteModel.setId(restaurante.getRestauranteId().getId());
        restauranteModel.setNome(restaurante.getNome());
        restauranteModel.setTaxaFrete(restaurante.getTaxaFrete());
        restauranteModel.setCozinha(cozinhaModel);
        restauranteModel.setFormaPagamentos(
                formaPagmentoTranslator.toCollectionFormaPagamentoModel(restaurante.getFormaPagamentos())
        );

        return restauranteModel;
    }

    public Restaurante toRestauranteFromRestauranteModel(RestauranteModel restauranteModel) {
        List<UUID> ids = restauranteModel.getFormaPagamentos().stream()
                .map(model -> model.getId())
                .collect(Collectors.toList());

        return RestauranteFactory.builder(
                        restauranteModel.getId(),
                        restauranteModel.getNome(),
                        restauranteModel.getTaxaFrete(),
                        restauranteModel.getCozinha().getId()
                ).adicionarFormasPagamentos(ids)
                .build();
    }
}
