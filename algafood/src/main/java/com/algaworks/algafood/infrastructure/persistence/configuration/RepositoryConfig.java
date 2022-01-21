package com.algaworks.algafood.infrastructure.persistence.configuration;

import com.algaworks.algafood.domain.model.cidade.CidadeRepository;
import com.algaworks.algafood.domain.model.cozinha.CozinhaRepository;
import com.algaworks.algafood.domain.model.estado.EstadoRepository;
import com.algaworks.algafood.domain.model.formapagamento.FormaPagamentoRepository;
import com.algaworks.algafood.domain.model.grupo.GrupoRepository;
import com.algaworks.algafood.domain.model.permissao.PermissaoRepository;
import com.algaworks.algafood.domain.model.produto.ProdutoRepository;
import com.algaworks.algafood.domain.model.restaurante.RestauranteRepository;
import com.algaworks.algafood.domain.model.usuario.UsuarioRepository;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.repository.*;
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

    @Bean
    @Primary
    public ProdutoRepository produtoRepository(MysqlProdutoRepository repository) {
        return repository;
    }

    @Bean
    @Primary
    public GrupoRepository grupoRepository(MysqlGrupoRepository repository) {
        return repository;
    }

    @Bean
    @Primary
    public UsuarioRepository usuarioRepository(MysqlUsuarioRepository repository) {
        return repository;
    }
}
