package com.algaworks.algafood.infrastructure.persistence.database.mysql.service;

import com.algaworks.algafood.domain.model.grupo.Grupo;
import com.algaworks.algafood.domain.model.grupo.GrupoFactory;
import com.algaworks.algafood.domain.model.grupo.GrupoId;
import com.algaworks.algafood.domain.model.permissao.Permissao;
import com.algaworks.algafood.domain.model.permissao.PermissaoId;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.GrupoModel;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.PermissaoModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GrupoTranslator {

    public GrupoModel toGrupoModel(Grupo grupo) {
        Set<PermissaoModel> permissoes = grupo.getPermissoes()
                .stream()
                .map(permissao -> {
                    PermissaoModel permissaoModel = new PermissaoModel();
                    permissaoModel.setId(permissao.getId());
                    return permissaoModel;
                }).collect(Collectors.toSet());

        GrupoModel grupoModel = new GrupoModel();
        grupoModel.setId(grupo.getGrupoId().getId());
        grupoModel.setNome(grupo.getNome());
        grupoModel.setPermissoes(permissoes);

        return grupoModel;
    }

    public Grupo toGrupo(GrupoModel grupoModel) {

        Set<UUID> permissosId = grupoModel.getPermissoes()
                .stream()
                .map(permissaoModel -> permissaoModel.getId())
                .collect(Collectors.toSet());

        return GrupoFactory.builder(grupoModel.getId(), grupoModel.getNome())
                .adicionarPermissoes(permissosId)
                .build();
    }
}
