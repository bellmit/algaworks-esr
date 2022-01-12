package com.algaworks.algafood.domain.model.permissao;

import com.algaworks.algafood.domain.model.permissao.Permissao;

import java.util.List;
import java.util.UUID;

public interface PermissaoService {
    List<Permissao> listar();
    void adicionar(Permissao permissao);
    Permissao buscar(UUID id);
    void atualizar(Permissao permissao);
    void remover(Permissao permissao);
}
