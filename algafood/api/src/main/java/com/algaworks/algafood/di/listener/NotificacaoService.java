package com.algaworks.algafood.di.listener;

import com.algaworks.algafood.di.service.ClienteAtivado;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoService {

    @EventListener
    public void clienteAtivoListener(ClienteAtivado clienteAtivado) {
        System.out.println("Cliente " + clienteAtivado.getCliente().getNome() + ": agora esta ativo!");
    }
}
