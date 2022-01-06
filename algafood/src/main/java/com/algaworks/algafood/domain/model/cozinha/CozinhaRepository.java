package com.algaworks.algafood.domain.model.cozinha;

import java.util.List;

public interface CozinhaRepository {
    List<Cozinha> listar();
    void adicionar(Cozinha cozinha);
}
