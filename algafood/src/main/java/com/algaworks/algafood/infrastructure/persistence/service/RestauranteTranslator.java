package com.algaworks.algafood.infrastructure.persistence.service;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.infrastructure.persistence.model.RestauranteModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class RestauranteTranslator {

    private CozinhaTranslator cozinhaTranslator;

    public RestauranteModel toRestauranteModelFromRestaurante(Restaurante restaurante) {
        RestauranteModel restauranteModel = new RestauranteModel();
        restauranteModel.setId(restaurante.getId());
        restauranteModel.setNome(restaurante.getNome());
        restauranteModel.setTaxaFrete(restaurante.getTaxaFrete());
        return restauranteModel;
    }

    public Restaurante toRestauranteFromRestauranteModel(RestauranteModel restauranteModel) {
        Restaurante restaurante = new Restaurante(
                restauranteModel.getId(),
                restauranteModel.getNome(),
                restauranteModel.getTaxaFrete(),
                cozinhaTranslator.toCozinhaFromCozinhaModel(restauranteModel.getCozinha()));
        return restaurante;
    }
}
