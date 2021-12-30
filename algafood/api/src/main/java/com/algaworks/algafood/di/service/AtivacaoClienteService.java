package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.NivelUrgencia;
import com.algaworks.algafood.di.notificacao.Notificador;
import com.algaworks.algafood.di.notificacao.TipoDoNotificador;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    private Notificador notificador;

    public AtivacaoClienteService(@TipoDoNotificador(NivelUrgencia.URGENTE) Notificador notificador) {
        this.notificador = notificador;
    }

    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}
