package com.algaworks.algafood.infrastructure.persistence.model.restaurante;

import com.algaworks.algafood.domain.model.cozinha.CozinhaId;
import com.algaworks.algafood.domain.model.restaurante.Restaurante;
import com.algaworks.algafood.domain.model.restaurante.RestauranteId;
import com.algaworks.algafood.infrastructure.persistence.model.cozinha.CozinhaModel;
import com.algaworks.algafood.infrastructure.persistence.model.restaurante.RestauranteModel;
import com.algaworks.algafood.infrastructure.persistence.model.cozinha.CozinhaTranslator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RestauranteTranslator {

    private CozinhaTranslator cozinhaTranslator;

    public RestauranteModel toRestauranteModelFromRestaurante(Restaurante restaurante) {
        CozinhaModel cozinhaModel = new CozinhaModel();
        cozinhaModel.setId(restaurante.getCozinhaId().getId());

        RestauranteModel restauranteModel = new RestauranteModel();
        restauranteModel.setId(restaurante.getRestauranteId().getId());
        restauranteModel.setNome(restaurante.getNome());
        restauranteModel.setTaxaFrete(restaurante.getTaxaFrete());
        restauranteModel.setCozinha(cozinhaModel);

        return restauranteModel;
    }

    public Restaurante toRestauranteFromRestauranteModel(RestauranteModel restauranteModel) {
        Restaurante restaurante = new Restaurante(
                new RestauranteId(restauranteModel.getId()),
                restauranteModel.getNome(),
                restauranteModel.getTaxaFrete(),
                new CozinhaId(restauranteModel.getCozinha().getId()));
        return restaurante;
    }
}
