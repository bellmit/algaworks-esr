package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.model.Cozinha;

import java.util.List;
import java.util.UUID;

public interface CozinhaService {
    List<Cozinha> listar();
    void adicionar(Cozinha cozinha);
    Cozinha buscar(UUID id);
    void atualizar(Cozinha cozinha);
    void remover(UUID id);
}
