package com.algaworks.algafood.port.adapter.service;

import com.algaworks.algafood.domain.model.permissao.Permissao;
import com.algaworks.algafood.port.adapter.persistence.model.PermissaoModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class PermissaoTranslator {

    public PermissaoModel toPermissaoModelFromPermissao(Permissao permissao) {
        PermissaoModel permissaoModel = new PermissaoModel();
        permissaoModel.setId(UUID.fromString(permissao.getId()));
        permissaoModel.setNome(permissao.getNome());
        permissaoModel.setDescricao(permissao.getDescricao());
        return permissaoModel;
    }

    public Permissao toPermissaoFromPermissaoModel(PermissaoModel permissaoModel) {
        return new Permissao(
                permissaoModel.getId().toString(),
                permissaoModel.getNome(),
                permissaoModel.getDescricao()
        );
    }
}
