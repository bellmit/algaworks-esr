package com.algaworks.algafood.infrastructure.configuration.domain;

import com.algaworks.algafood.domain.repository.*;
import com.algaworks.algafood.domain.service.*;
import com.algaworks.algafood.domain.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainServiceConfig {

    @Bean
    public CidadeService cidadeService(CidadeRepository repository) {
        return new DomainCidadeService(repository);
    }

    @Bean
    public CozinhaService cozinhaService(CozinhaRepository repository) {
        return new DomainCozinhaService(repository);
    }

    @Bean
    public EstadoService estadoService(EstadoRepository repository) {
        return new DomainEstadoService(repository);
    }

    @Bean
    public FormaPagamentoService formaPagamentoService(FormaPagamentoRepository repository) {
        return new DomainFormaPagamentoService(repository);
    }

    @Bean
    public PermissaoService permissaoService(PermissaoRepository repository) {
        return new DomainPermissaoService(repository);
    }

    @Bean
    public RestauranteService restauranteService(RestauranteRepository repository) {
        return new DomainRestauranteService(repository);
    }
}
