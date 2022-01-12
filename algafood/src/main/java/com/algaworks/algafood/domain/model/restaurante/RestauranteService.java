package com.algaworks.algafood.domain.model.restaurante;

import com.algaworks.algafood.domain.model.restaurante.Restaurante;
import com.algaworks.algafood.domain.model.restaurante.RestauranteId;

import java.util.List;
import java.util.UUID;

public interface RestauranteService {
    List<Restaurante> listar();
    void adicionar(Restaurante restaurante);
    Restaurante buscar(RestauranteId restauranteId);
    void atualizar(Restaurante restaurante);
    void remover(RestauranteId restauranteId);
}
