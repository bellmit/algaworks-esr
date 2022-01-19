package com.algaworks.algafood.domain.model.usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    List<Usuario> listar();
    void adicionar(Usuario usuario);
    void atualizar(Usuario usuario);
    void remover(UsuarioId usuarioId);
    Optional<Usuario> buscar(UsuarioId usuarioId);
    boolean existeUsuarioComId(UsuarioId usuarioId);
}
