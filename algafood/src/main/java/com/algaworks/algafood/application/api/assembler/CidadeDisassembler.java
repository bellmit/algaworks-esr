package com.algaworks.algafood.application.api.assembler;

import com.algaworks.algafood.application.api.model.CidadeRequest;
import com.algaworks.algafood.domain.model.cidade.Cidade;
import com.algaworks.algafood.domain.model.cidade.CidadeFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CidadeDisassembler {

    public Cidade toDomain(CidadeRequest cidadeRequest) {
        return this.toDomain(UUID.randomUUID(), cidadeRequest);
    }

    public Cidade toDomain(UUID cidadeId, CidadeRequest cidadeRequest) {
        return CidadeFactory.builder(
                cidadeId,
                cidadeRequest.getNome(),
                cidadeRequest.getEstadoId()
        ).build();
    }
}
