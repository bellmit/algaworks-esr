package com.algaworks.algafood.domain.model.cozinha;

import java.util.List;

public interface CozinhaService {
    List<Cozinha> listar();
    void adicionar(Cozinha cozinha);
    Cozinha buscar(CozinhaId cozinhaId);
    void atualizar(Cozinha cozinha);
    void remover(CozinhaId cozinhaId);
}
