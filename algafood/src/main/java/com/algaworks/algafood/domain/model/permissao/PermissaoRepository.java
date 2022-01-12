package com.algaworks.algafood.domain.model.permissao;

import com.algaworks.algafood.domain.model.permissao.Permissao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PermissaoRepository {
    List<Permissao> listar();
    void adicionar(Permissao permissao);
    Optional<Permissao> buscar(PermissaoId permissaoId);
    Optional<Permissao> buscarPeloNome(String descricao);
    void atualizar(Permissao permissao);
    void remover(PermissaoId permissaoId);
    boolean existePermissaoComNome(String nome);
    boolean existePermissaoComNomeComIdDiferente(String nome, PermissaoId permissaoId);
    boolean existePermissaoComId(PermissaoId permissaoId);
}
