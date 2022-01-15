package com.algaworks.algafood.application.api.cozinha;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CozinhaResponse {
    UUID id;
    String nome;
}
