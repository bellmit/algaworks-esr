package com.algaworks.algafood.domain.model.usuario;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DomainUsuarioService implements UsuarioService{

    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.listar();
    }

    @Override
    public void adicionar(Usuario usuario) {
        usuarioRepository.adicionar(usuario);
    }

    @Override
    public void atualizar(Usuario usuario) {
        if(!usuarioRepository.existeUsuarioComId(usuario.getUsuarioId())) {
            throw new UsuarioNaoEncontradoException(usuario.getUsuarioId().getId());
        }
        usuarioRepository.atualizar(usuario);
    }

    @Override
    public void remover(UsuarioId usuarioId) {
        if(!usuarioRepository.existeUsuarioComId(usuarioId)) {
            throw new UsuarioNaoEncontradoException(usuarioId.getId());
        }
        usuarioRepository.remover(usuarioId);
    }

    @Override
    public Usuario buscar(UsuarioId usuarioId) {
        return usuarioRepository.buscar(usuarioId)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(usuarioId.getId()));
    }
}
