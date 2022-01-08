package com.algaworks.algafood.domain.model.cidade;

import java.util.List;
import java.util.Optional;

public interface CidadeRepository {
    List<Cidade> listar();
    void adicionar(Cidade cidade);
    Optional<Cidade> buscar(String id);
    Optional<Cidade> buscarPeloNome(String nome);
    void atualizar(Cidade cidade);
    void remover(Cidade cidade);
    boolean existeCidadeComNome(String nome);
    boolean existeCidadeComNomeComIdDiferente(String nome, String id);
}
