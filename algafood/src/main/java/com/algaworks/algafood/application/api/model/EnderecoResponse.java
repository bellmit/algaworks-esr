package com.algaworks.algafood.application.api.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class EnderecoResponse {
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private UUID cidadeId;
}
