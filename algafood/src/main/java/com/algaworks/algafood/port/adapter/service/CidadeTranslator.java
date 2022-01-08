package com.algaworks.algafood.port.adapter.service;

import com.algaworks.algafood.domain.model.cidade.Cidade;
import com.algaworks.algafood.domain.model.cozinha.Cozinha;
import com.algaworks.algafood.port.adapter.persistence.model.CidadeModel;
import com.algaworks.algafood.port.adapter.persistence.model.CozinhaModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class CidadeTranslator {

    private EstadoTranslator estadoTranslator;

    public CidadeModel toCidadeModelFromCidade(Cidade cidade) {
        CidadeModel cidadeModel = new CidadeModel();
        cidadeModel.setId(UUID.fromString(cidade.getId()));
        cidadeModel.setNome(cidade.getNome());
        return cidadeModel;
    }

    public Cidade toCidadeFromCidadeModel(CidadeModel cidadeModel) {
        return new Cidade(
                cidadeModel.getId().toString(),
                cidadeModel.getNome(),
                estadoTranslator.toEstadoFromEstadoModel(cidadeModel.getEstado()));
    }
}
