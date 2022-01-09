package com.algaworks.algafood.infrastructure.persistence.service;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.infrastructure.persistence.model.CozinhaModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class CozinhaTranslator {

    public CozinhaModel toCozinhaModelFromCozinha(Cozinha cozinha) {
        CozinhaModel cozinhaModel = new CozinhaModel();
        cozinhaModel.setId(cozinha.getId());
        cozinhaModel.setNome(cozinha.getNome());
        return cozinhaModel;
    }

    public Cozinha toCozinhaFromCozinhaModel(CozinhaModel cozinhaModel) {
        return new Cozinha(cozinhaModel.getId(), cozinhaModel.getNome());
    }
}
