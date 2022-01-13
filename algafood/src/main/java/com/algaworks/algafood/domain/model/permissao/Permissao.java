package com.algaworks.algafood.domain.model.permissao;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Getter
@ToString
public class Permissao {
    private PermissaoId permissaoId;
    private String nome;
    private String descricao;

    public Permissao(PermissaoId permissaoId, String nome, String descricao) {
        this.setPermissaoId(permissaoId);
        this.setNome(nome);
        this.setDescricao(descricao);
    }

    private void setPermissaoId(PermissaoId permissaoId) {
        if (permissaoId == null) {
            throw new PropriedadeInvalidaException(Permissao.class, "permissaoId", "deve ser informado");
        }

        this.permissaoId = permissaoId;
    }

    private void setNome(String nome) {
        if (!StringUtils.hasText(nome)) {
            throw new PropriedadeInvalidaException(Permissao.class, "nome", "deve ser informado");
        }

        this.nome = nome;
    }

    private void setDescricao(String descricao) {
        if (!StringUtils.hasText(descricao)) {
            throw new PropriedadeInvalidaException(Permissao.class, "descricao", "deve ser informado");
        }

        this.descricao = descricao;
    }
}
