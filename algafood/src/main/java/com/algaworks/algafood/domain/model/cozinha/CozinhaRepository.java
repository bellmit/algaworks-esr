package com.algaworks.algafood.domain.model.cozinha;

import java.util.List;
import java.util.Optional;

public interface CozinhaRepository {
    List<Cozinha> listar();
    void adicionar(Cozinha cozinha);
    Optional<Cozinha> buscar(String codigo);
    void atualizar(Cozinha cozinha);
}
