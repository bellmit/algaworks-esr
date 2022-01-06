package com.algaworks.algafood.port.adapter.service;

import com.algaworks.algafood.domain.model.cozinha.Cozinha;
import com.algaworks.algafood.port.adapter.persistence.model.CozinhaModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CozinhaTranslator {


    public CozinhaModel toCozinhaModelFromCozinha(Cozinha cozinha) {
        CozinhaModel cozinhaModel = new CozinhaModel();
        cozinhaModel.setNome(cozinha.getNome());
        return cozinhaModel;
    }

    public Cozinha toCozinhaFromCozinhaModel(CozinhaModel cozinhaModel) {
        return new Cozinha(cozinhaModel.getNome());
    }
}
