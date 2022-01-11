package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Cozinha;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CozinhaRepository {
    List<Cozinha> listar();
    void adicionar(Cozinha cozinha);
    Optional<Cozinha> buscar(UUID id);
    Optional<Cozinha> buscarPeloNome(String nome);
    void atualizar(Cozinha cozinha);
    void remover(UUID id);
    boolean existeCozinhaComId(UUID id);
    boolean existeCozinhaComNome(String nome);
    boolean existeCozinhaComNomeComIdDiferente(String nome, UUID id);
}
