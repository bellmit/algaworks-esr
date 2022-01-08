package com.algaworks.algafood.domain.model.permissao;

import java.util.List;
import java.util.Optional;

public interface PermissaoRepository {
    List<Permissao> listar();
    void adicionar(Permissao permissao);
    Optional<Permissao> buscar(String id);
    Optional<Permissao> buscarPeloNome(String descricao);
    void atualizar(Permissao permissao);
    void remover(Permissao permissao);
    boolean existePermissaoComNome(String nome);
    boolean existePermissaoComNomeComIdDiferente(String nome, String id);
}
