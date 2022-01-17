package com.algaworks.algafood.domain.model.endereco;

import com.algaworks.algafood.domain.model.cidade.CidadeId;
import lombok.Getter;

@Getter
public class Endereco {
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private CidadeId cidadeId;

    public Endereco(String cep, String logradouro, String numero, String complemento, String bairro, CidadeId cidadeId) {
        this.setCep(cep);
        this.setLogradouro(logradouro);
        this.setNumero(numero);
        this.setComplemento(complemento);
        this.setBairro(bairro);
        this.setCidadeId(cidadeId);
    }

    private void setCep(String cep) {
        this.cep = cep;
    }

    private void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    private void setNumero(String numero) {
        this.numero = numero;
    }

    private void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    private void setBairro(String bairro) {
        this.bairro = bairro;
    }

    private void setCidadeId(CidadeId cidadeId) {
        this.cidadeId = cidadeId;
    }
}
