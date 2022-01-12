package com.algaworks.algafood.domain.model.cidade;

import com.algaworks.algafood.domain.model.cidade.Cidade;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CidadeRepository {
    List<Cidade> listar();
    void adicionar(Cidade cidade);
    Optional<Cidade> buscar(UUID id);
    Optional<Cidade> buscarPeloNome(String nome);
    void atualizar(Cidade cidade);
    void remover(Cidade cidade);
    boolean existeCidadeComNome(String nome);
    boolean existeCidadeComNomeComIdDiferente(String nome, UUID id);
}
