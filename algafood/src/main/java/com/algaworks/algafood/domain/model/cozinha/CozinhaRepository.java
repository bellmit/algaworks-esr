package com.algaworks.algafood.domain.model.cozinha;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CozinhaRepository {
    List<Cozinha> listar();
    void adicionar(Cozinha cozinha);
    Optional<Cozinha> buscar(CozinhaId cozinhaId);
    Optional<Cozinha> buscarPeloNome(String nome);
    void atualizar(Cozinha cozinha);
    void remover(CozinhaId cozinhaId);
    boolean existeCozinhaComId(CozinhaId cozinhaId);
    boolean existeCozinhaComNome(String nome);
    boolean existeCozinhaComNomeComIdDiferente(String nome, CozinhaId cozinhaId);
}
