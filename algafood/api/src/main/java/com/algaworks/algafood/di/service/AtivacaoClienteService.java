package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.NivelUrgencia;
import com.algaworks.algafood.di.notificacao.Notificador;
import com.algaworks.algafood.di.notificacao.TipoDoNotificador;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    private ApplicationEventPublisher publisher;

    public AtivacaoClienteService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void ativar(Cliente cliente) {
        cliente.ativar();

        publisher.publishEvent(new ClienteAtivado(cliente));
    }
}
