package com.algaworks.algafood.infrastructure.persistence.service;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.infrastructure.persistence.model.CidadeModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class CidadeTranslator {

    private EstadoTranslator estadoTranslator;

    public CidadeModel toCidadeModelFromCidade(Cidade cidade) {
        CidadeModel cidadeModel = new CidadeModel();
        cidadeModel.setId(cidade.getId());
        cidadeModel.setNome(cidade.getNome());
        return cidadeModel;
    }

    public Cidade toCidadeFromCidadeModel(CidadeModel cidadeModel) {
        return new Cidade(
                cidadeModel.getId(),
                cidadeModel.getNome(),
                estadoTranslator.toEstadoFromEstadoModel(cidadeModel.getEstado()));
    }
}
