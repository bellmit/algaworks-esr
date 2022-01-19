package com.algaworks.algafood.infrastructure.persistence.database.mysql.service;

import com.algaworks.algafood.domain.model.usuario.Usuario;
import com.algaworks.algafood.domain.model.usuario.UsuarioFactory;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.GrupoModel;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.UsuarioModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UsuarioTranslator {

    public UsuarioModel toUsuarioModel(Usuario usuario) {
        Set<GrupoModel> grupos = usuario.getGrupos()
                .stream()
                .map(grupo -> {
                    GrupoModel grupoModel = new GrupoModel();
                    grupoModel.setId(grupo.getId());
                    return grupoModel;
                }).collect(Collectors.toSet());

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setId(usuario.getUsuarioId().getId());
        usuarioModel.setNome(usuario.getNome());
        usuarioModel.setEmail(usuario.getEmail());
        usuarioModel.setSenha(usuario.getSenha());
        usuarioModel.setDataCadastro(usuario.getDataCadastro());
        usuarioModel.setGrupos(grupos);

        return usuarioModel;
    }

    public Usuario toUsuario(UsuarioModel usuarioModel) {

        Set<UUID> gruposIds = usuarioModel.getGrupos()
                .stream()
                .map(grupoModel -> grupoModel.getId())
                .collect(Collectors.toSet());

        return UsuarioFactory.builder(
                        usuarioModel.getId(),
                        usuarioModel.getNome(),
                        usuarioModel.getEmail(),
                        usuarioModel.getSenha(),
                        usuarioModel.getDataCadastro()
                ).adicionarGrupos(gruposIds)
                .build();
    }
}
