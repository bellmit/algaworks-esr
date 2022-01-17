package com.algaworks.algafood.infrastructure.persistence.database.mysql.service;

import com.algaworks.algafood.domain.model.permissao.Permissao;
import com.algaworks.algafood.domain.model.permissao.PermissaoId;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.PermissaoModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PermissaoTranslator {

    public PermissaoModel toPermissaoModelFromPermissao(Permissao permissao) {
        PermissaoModel permissaoModel = new PermissaoModel();
        permissaoModel.setId(permissao.getPermissaoId().getId());
        permissaoModel.setNome(permissao.getNome());
        permissaoModel.setDescricao(permissao.getDescricao());
        return permissaoModel;
    }

    public Permissao toPermissaoFromPermissaoModel(PermissaoModel permissaoModel) {
        return new Permissao(
                new PermissaoId(permissaoModel.getId()),
                permissaoModel.getNome(),
                permissaoModel.getDescricao()
        );
    }
}
