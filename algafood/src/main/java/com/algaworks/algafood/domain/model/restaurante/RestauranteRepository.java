package com.algaworks.algafood.domain.model.restaurante;

import java.util.List;
import java.util.Optional;

public interface RestauranteRepository {
    List<Restaurante> listar();
    void adicionar(Restaurante restaurante);
    Optional<Restaurante> buscar(String id);
    Optional<Restaurante> buscarPeloNome(String nome);
    void atualizar(Restaurante restaurante);
    void remover(Restaurante restaurante);
}
