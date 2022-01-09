package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.model.Restaurante;

import java.util.List;
import java.util.UUID;

public interface RestauranteService {
    List<Restaurante> listar();
    void adicionar(Restaurante restaurante);
    Restaurante buscar(UUID id);
    void atualizar(Restaurante restaurante);
    void remover(Restaurante restaurante);
}
