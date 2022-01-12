package com.algaworks.algafood.infrastructure.persistence.configuration;

import com.algaworks.algafood.domain.model.cidade.CidadeRepository;
import com.algaworks.algafood.domain.model.cozinha.CozinhaRepository;
import com.algaworks.algafood.domain.model.estado.EstadoRepository;
import com.algaworks.algafood.domain.model.formapagamento.FormaPagamentoRepository;
import com.algaworks.algafood.domain.model.permissao.PermissaoRepository;
import com.algaworks.algafood.domain.model.restaurante.RestauranteRepository;
import com.algaworks.algafood.infrastructure.persistence.model.cidade.MysqlCidadeRepository;
import com.algaworks.algafood.infrastructure.persistence.model.cozinha.MysqlCozinhaRepository;
import com.algaworks.algafood.infrastructure.persistence.model.estado.MysqlEstadoRepository;
import com.algaworks.algafood.infrastructure.persistence.model.formapagamento.MysqlFormaPagamentoRepository;
import com.algaworks.algafood.infrastructure.persistence.model.permissao.MysqlPermissaoRepository;
import com.algaworks.algafood.infrastructure.persistence.model.restaurante.MysqlRestauranteRepository;
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
