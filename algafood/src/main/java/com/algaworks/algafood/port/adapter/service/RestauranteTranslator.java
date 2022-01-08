package com.algaworks.algafood.port.adapter.service;

import com.algaworks.algafood.domain.model.cozinha.Cozinha;
import com.algaworks.algafood.domain.model.restaurante.Restaurante;
import com.algaworks.algafood.port.adapter.persistence.model.CozinhaModel;
import com.algaworks.algafood.port.adapter.persistence.model.RestauranteModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class RestauranteTranslator {

    private CozinhaTranslator cozinhaTranslator;

    public RestauranteModel toRestauranteModelFromRestaurante(Restaurante restaurante) {
        RestauranteModel restauranteModel = new RestauranteModel();
        restauranteModel.setId(UUID.fromString(restaurante.getId()));
        restauranteModel.setNome(restaurante.getNome());
        restauranteModel.setTaxaFrete(restaurante.getTaxaFrete());
        return restauranteModel;
    }

    public Restaurante toRestauranteFromRestauranteModel(RestauranteModel restauranteModel) {
        Restaurante restaurante = new Restaurante(
                restauranteModel.getId().toString(),
                restauranteModel.getNome(),
                cozinhaTranslator.toCozinhaFromCozinhaModel(restauranteModel.getCozinha()));
        restaurante.atualizarFrete(restauranteModel.getTaxaFrete());
        return restaurante;
    }
}
