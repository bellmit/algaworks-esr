package com.algaworks.algafood.application.api.assembler;

import com.algaworks.algafood.application.api.model.CozinhaResponse;
import com.algaworks.algafood.domain.model.cozinha.Cozinha;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CozinhaAssembler {

    public CozinhaResponse toModel(Cozinha cozinha) {
        return CozinhaResponse.builder()
                .id(cozinha.getCozinhaId().getId())
                .nome(cozinha.getNome())
                .build();
    }

    public List<CozinhaResponse> toCollectionModel(List<Cozinha> cozinhas) {
        return cozinhas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
