package com.algaworks.algafood.infrastructure.persistence.model.cidade;

import com.algaworks.algafood.domain.model.cidade.Cidade;
import com.algaworks.algafood.domain.model.cidade.CidadeId;
import com.algaworks.algafood.domain.model.estado.Estado;
import com.algaworks.algafood.domain.model.estado.EstadoId;
import com.algaworks.algafood.infrastructure.persistence.model.estado.EstadoModel;
import com.algaworks.algafood.infrastructure.persistence.model.estado.EstadoTranslator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CidadeTranslator {

    public CidadeModel toCidadeModelFromCidade(Cidade cidade) {
        EstadoModel estadoModel = new EstadoModel();
        estadoModel.setId(cidade.getEstadoId().getId());

        CidadeModel cidadeModel = new CidadeModel();
        cidadeModel.setId(cidade.getCidadeId().getId());
        cidadeModel.setNome(cidade.getNome());
        cidadeModel.setEstado(estadoModel);

        return cidadeModel;
    }

    public Cidade toCidadeFromCidadeModel(CidadeModel cidadeModel) {
        return new Cidade(
                new CidadeId(cidadeModel.getId()),
                cidadeModel.getNome(),
                new EstadoId(cidadeModel.getEstado().getId()));
    }
}
