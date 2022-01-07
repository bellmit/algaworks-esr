package com.algaworks.algafood.application.cozinha;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizarCozinhaCommand {
    private String codigo;
    private String nome;
}
