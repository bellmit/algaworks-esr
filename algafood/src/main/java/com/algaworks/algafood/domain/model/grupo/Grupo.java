package com.algaworks.algafood.domain.model.grupo;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import com.algaworks.algafood.domain.model.permissao.PermissaoId;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Grupo {

    private GrupoId grupoId;
    private String nome;
    private Set<PermissaoId> permissoes;

    public Grupo(GrupoId grupoId, String nome) {
        this();
        this.setGrupoId(grupoId);
        this.setNome(nome);
    }

    private Grupo() {
        this.permissoes = new HashSet<>();
    }

    public void adicionarPermissao(PermissaoId permissaoId) {
        if(permissaoId != null) {
            this.permissoes.add(permissaoId);
        }
    }

    private void setGrupoId(GrupoId grupoId) {
        if(grupoId == null) {
            throw new PropriedadeInvalidaException(Grupo.class, "grupoId", "deve ser informado");
        }

        this.grupoId = grupoId;
    }

    private void setNome(String nome) {
        if(!StringUtils.hasText(nome)) {
            throw new PropriedadeInvalidaException(Grupo.class, "nome", "deve ser informado");
        }
        this.nome = nome;
    }
}
