package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Restaurante;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RestauranteRepository {
    List<Restaurante> listar();
    void adicionar(Restaurante restaurante);
    Optional<Restaurante> buscar(UUID id);
    Optional<Restaurante> buscarPeloNome(String nome);
    void atualizar(Restaurante restaurante);
    void remover(Restaurante restaurante);
    boolean existeRestauranteComNome(String nome);
    boolean existeRestauranteComNomeComIdDiferente(String nome, UUID id);
    boolean existeRestauranteComCozinhaId(UUID id);
}
