package com.algaworks.algafood.application.api.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CozinhaResponse {
    UUID id;
    String nome;
}
