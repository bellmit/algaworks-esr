package com.algaworks.algafood.di.modelo;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Cliente {
    @NonNull
    private String nome;
    @NonNull
    private String email;
    @NonNull
    private String telefone;
    private boolean ativo;

    public void ativar() {
        this.ativo = true;
    }
}
