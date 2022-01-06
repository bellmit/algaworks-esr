package com.algaworks.algafood.application.cozinha;

import com.algaworks.algafood.domain.model.cozinha.Cozinha;
import com.algaworks.algafood.domain.model.cozinha.CozinhaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CozinhaApplicationService {

    private CozinhaRepository cozinhaRepository;

    public void adicionarCozinha(AdicionarCozinhaCommand command) {
        Cozinha cozinha = new Cozinha(command.getNome());
        cozinhaRepository.adicionar(cozinha);
    }
}
