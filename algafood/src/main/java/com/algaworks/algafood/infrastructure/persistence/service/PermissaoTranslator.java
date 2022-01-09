package com.algaworks.algafood.infrastructure.persistence.service;

import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.infrastructure.persistence.model.PermissaoModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class PermissaoTranslator {

    public PermissaoModel toPermissaoModelFromPermissao(Permissao permissao) {
        PermissaoModel permissaoModel = new PermissaoModel();
        permissaoModel.setId(permissao.getId());
        permissaoModel.setNome(permissao.getNome());
        permissaoModel.setDescricao(permissao.getDescricao());
        return permissaoModel;
    }

    public Permissao toPermissaoFromPermissaoModel(PermissaoModel permissaoModel) {
        return new Permissao(
                permissaoModel.getId(),
                permissaoModel.getNome(),
                permissaoModel.getDescricao()
        );
    }
}
