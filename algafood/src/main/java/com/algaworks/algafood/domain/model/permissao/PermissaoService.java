package com.algaworks.algafood.domain.model.permissao;

import java.util.List;

public interface PermissaoService {
    List<Permissao> listar();
    void adicionar(Permissao permissao);
    Permissao buscar(PermissaoId permissaoId);
    void atualizar(Permissao permissao);
    void remover(PermissaoId permissaoId);
}
