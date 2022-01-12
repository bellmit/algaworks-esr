package com.algaworks.algafood.domain.model.permissao;

import com.algaworks.algafood.domain.model.permissao.Permissao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PermissaoRepository {
    List<Permissao> listar();
    void adicionar(Permissao permissao);
    Optional<Permissao> buscar(UUID id);
    Optional<Permissao> buscarPeloNome(String descricao);
    void atualizar(Permissao permissao);
    void remover(Permissao permissao);
    boolean existePermissaoComNome(String nome);
    boolean existePermissaoComNomeComIdDiferente(String nome, UUID id);
}
