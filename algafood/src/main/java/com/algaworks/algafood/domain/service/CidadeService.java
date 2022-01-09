package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.model.Cidade;

import java.util.List;
import java.util.UUID;

public interface CidadeService {
    List<Cidade> listar();
    void adicionar(Cidade cidade);
    void atualizar(Cidade cidade);
    void remover(Cidade cidade);
    Cidade buscar(UUID id);
}
