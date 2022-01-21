package com.algaworks.algafood.domain.model.grupo;

import com.algaworks.algafood.domain.model.permissao.PermissaoId;

import java.util.Set;
import java.util.UUID;

public class GrupoFactory {

    private Grupo grupo;

    private GrupoFactory(Grupo grupo) {
        this.grupo = grupo;
    }

    public static GrupoFactory builder(UUID grupoId, String nome) {
        Grupo grupo = new Grupo(new GrupoId(grupoId), nome);
        return new GrupoFactory(grupo);
    }

    public GrupoFactory adicionarPermissoes(Set<UUID> permissoes) {
        permissoes.forEach(id -> this.grupo.adicionarPermissao(new PermissaoId(id)));
        return this;
    }

    public Grupo build() {
        return this.grupo;
    }
}
