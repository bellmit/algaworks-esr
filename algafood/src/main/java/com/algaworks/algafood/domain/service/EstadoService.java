package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.model.Estado;

import java.util.List;
import java.util.UUID;

public interface EstadoService {
    List<Estado> listar();
    void adicionar(Estado cidade);
    Estado buscar(UUID id);
    void atualizar(Estado estado);
    void remover(Estado estado);
}
