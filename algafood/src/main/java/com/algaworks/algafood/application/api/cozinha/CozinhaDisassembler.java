package com.algaworks.algafood.application.api.cozinha;

import com.algaworks.algafood.domain.model.cozinha.Cozinha;
import com.algaworks.algafood.domain.model.cozinha.CozinhaId;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CozinhaDisassembler {

    public Cozinha toDomain(CozinhaRequest cozinhaRequest) {
        return this.toDomain(UUID.randomUUID(), cozinhaRequest);
    }

    public Cozinha toDomain(UUID cozinhaID, CozinhaRequest cozinhaRequest) {
        return new Cozinha(
                new CozinhaId(cozinhaID),
                cozinhaRequest.getNome()
        );
    }
}
