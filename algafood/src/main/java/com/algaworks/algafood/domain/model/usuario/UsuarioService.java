package com.algaworks.algafood.domain.model.usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> listar();
    void adicionar(Usuario usuario);
    void atualizar(Usuario usuario);
    void remover(UsuarioId usuarioId);
    Usuario buscar(UsuarioId usuarioId);
}
