package com.algaworks.algafood.application.api.assembler;

import com.algaworks.algafood.application.api.model.CidadeResponse;
import com.algaworks.algafood.domain.model.cidade.Cidade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CidadeAssembler {

    public CidadeResponse toModel(Cidade cidade) {
        return CidadeResponse.builder()
                .id(cidade.getCidadeId().getId())
                .nome(cidade.getNome())
                .estadoId(cidade.getEstadoId().getId())
                .build();
    }

    public List<CidadeResponse> toCollectionModel(List<Cidade> cidades) {
        return cidades.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
