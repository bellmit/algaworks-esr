package com.algaworks.algafood.infrastructure.configuration.domain;

import com.algaworks.algafood.domain.repository.*;
import com.algaworks.algafood.infrastructure.persistence.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RepositoryConfig {

    @Bean
    @Primary
    public CidadeRepository cidadeRepository(MysqlCidadeRepository repository) {
        return repository;
    }

    @Bean
    @Primary
    public CozinhaRepository cozinhaRepository(MysqlCozinhaRepository repository) {
        return repository;
    }

    @Bean
    @Primary
    public EstadoRepository estadoRepository(MysqlEstadoRepository repository) {
        return repository;
    }

    @Bean
    @Primary
    public FormaPagamentoRepository formaPagamentoRepository(MysqlFormaPagamentoRepository repository) {
        return repository;
    }

    @Bean
    @Primary
    public PermissaoRepository permissaoRepository(MysqlPermissaoRepository repository) {
        return repository;
    }

    @Bean
    @Primary
    public RestauranteRepository restauranteRepository(MysqlRestauranteRepository repository) {
        return repository;
    }
}
