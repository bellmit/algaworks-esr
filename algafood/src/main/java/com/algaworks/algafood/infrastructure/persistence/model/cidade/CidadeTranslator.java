package com.algaworks.algafood.infrastructure.persistence.model.cidade;

import com.algaworks.algafood.domain.model.cidade.Cidade;
import com.algaworks.algafood.infrastructure.persistence.model.estado.EstadoTranslator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

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
