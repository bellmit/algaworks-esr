package com.algaworks.algafood.domain.model.usuario;

import com.algaworks.algafood.domain.model.grupo.GrupoId;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class UsuarioFactory {
    private Usuario usuario;

    private UsuarioFactory(Usuario usuario) {
        this.usuario = usuario;
    }

    public static UsuarioFactory builder(
            UUID id,
            String nome,
            String email,
            String senha,
            LocalDateTime dataCadastro
    ){
        Usuario usuario = new Usuario(
                new UsuarioId(id),
                nome,
                email,
                senha,
                dataCadastro
        );
        return new UsuarioFactory(usuario);
    }

    public UsuarioFactory adicionarGrupos(Set<UUID> ids) {
        ids.forEach(id -> this.usuario.adicionarGrupo(new GrupoId(id)));
        return this;
    }

    public Usuario build() {
        return this.usuario;
    }
}
