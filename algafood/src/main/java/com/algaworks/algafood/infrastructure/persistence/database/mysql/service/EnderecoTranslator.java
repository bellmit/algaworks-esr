package com.algaworks.algafood.infrastructure.persistence.database.mysql.service;

import com.algaworks.algafood.domain.model.endereco.Endereco;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.CidadeModel;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.EnderecoModel;
import org.springframework.stereotype.Component;

@Component
public class EnderecoTranslator {

    public EnderecoModel toEnderecoModel(Endereco endereco) {
        CidadeModel cidadeModel = new CidadeModel();
        cidadeModel.setId(endereco.getCidadeId().getId());

        EnderecoModel enderecoModel = new EnderecoModel();
        enderecoModel.setCep(endereco.getCep());
        enderecoModel.setLogradouro(endereco.getLogradouro());
        enderecoModel.setNumero(endereco.getNumero());
        enderecoModel.setComplemento(endereco.getComplemento());
        enderecoModel.setBairro(endereco.getBairro());
        enderecoModel.setCidade(cidadeModel);

        return enderecoModel;
    }
}
