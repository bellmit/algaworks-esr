package com.algaworks.algafood.di.notificacao;

import com.algaworks.algafood.di.modelo.Cliente;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Locale;

@RequiredArgsConstructor
public class NotificadorEmail implements Notificador {

    @Setter
    private boolean caixaAlta;
    @NonNull
    private String hostServidorSmtp;

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        if(caixaAlta) {
            mensagem = mensagem.toUpperCase(Locale.ROOT);
        }

        System.out.printf("Notificando %s através do e-mail %s usando o servidor SMTP %s: %s\n",
                cliente.getNome(), cliente.getEmail(), this.hostServidorSmtp, mensagem);
    }
}
