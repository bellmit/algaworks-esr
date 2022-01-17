package com.algaworks.algafood.infrastructure.persistence.database.mysql.service;

import com.algaworks.algafood.domain.model.cozinha.Cozinha;
import com.algaworks.algafood.domain.model.cozinha.CozinhaId;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.CozinhaModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CozinhaTranslator {

    public CozinhaModel toCozinhaModelFromCozinha(Cozinha cozinha) {
        CozinhaModel cozinhaModel = new CozinhaModel();
        cozinhaModel.setId(cozinha.getCozinhaId().getId());
        cozinhaModel.setNome(cozinha.getNome());
        return cozinhaModel;
    }

    public Cozinha toCozinhaFromCozinhaModel(CozinhaModel cozinhaModel) {
        return new Cozinha(
                new CozinhaId(cozinhaModel.getId()),
                cozinhaModel.getNome()
        );
    }
}
