package com.algaworks.algafood.application.api.assembler;

import com.algaworks.algafood.application.api.model.EnderecoResponse;
import com.algaworks.algafood.domain.model.endereco.Endereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoAssembler {

    public EnderecoResponse toModel(Endereco endereco) {
        return EnderecoResponse.builder()
                .cep(endereco.getCep())
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .bairro(endereco.getBairro())
                .cidadeId(endereco.getCidadeId().getId())
                .build();
    }
}
