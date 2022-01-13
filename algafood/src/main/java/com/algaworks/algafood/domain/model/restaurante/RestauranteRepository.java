package com.algaworks.algafood.domain.model.restaurante;

import com.algaworks.algafood.domain.model.cozinha.CozinhaId;
import com.algaworks.algafood.domain.model.restaurante.Restaurante;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RestauranteRepository {
    List<Restaurante> listar();
    void adicionar(Restaurante restaurante);
    Optional<Restaurante> buscar(RestauranteId restauranteId);
    Optional<Restaurante> buscarPeloNome(String nome);
    void atualizar(Restaurante restaurante);
    void remover(RestauranteId restauranteId);
    boolean existeRestauranteComNome(String nome);
    boolean existeRestauranteComNomeComIdDiferente(String nome, RestauranteId restauranteId);
    boolean existeRestauranteComCozinhaId(CozinhaId cozinhaId);
    boolean existeRestauranteComId(RestauranteId restauranteId);
}
