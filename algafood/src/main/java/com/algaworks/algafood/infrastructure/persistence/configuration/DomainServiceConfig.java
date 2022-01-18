package com.algaworks.algafood.infrastructure.persistence.configuration;

import com.algaworks.algafood.domain.model.cidade.CidadeRepository;
import com.algaworks.algafood.domain.model.cidade.CidadeService;
import com.algaworks.algafood.domain.model.cidade.DomainCidadeService;
import com.algaworks.algafood.domain.model.cozinha.CozinhaRepository;
import com.algaworks.algafood.domain.model.cozinha.CozinhaService;
import com.algaworks.algafood.domain.model.cozinha.DomainCozinhaService;
import com.algaworks.algafood.domain.model.estado.DomainEstadoService;
import com.algaworks.algafood.domain.model.estado.EstadoRepository;
import com.algaworks.algafood.domain.model.estado.EstadoService;
import com.algaworks.algafood.domain.model.formapagamento.DomainFormaPagamentoService;
import com.algaworks.algafood.domain.model.formapagamento.FormaPagamentoRepository;
import com.algaworks.algafood.domain.model.formapagamento.FormaPagamentoService;
import com.algaworks.algafood.domain.model.permissao.DomainPermissaoService;
import com.algaworks.algafood.domain.model.permissao.PermissaoRepository;
import com.algaworks.algafood.domain.model.permissao.PermissaoService;
import com.algaworks.algafood.domain.model.produto.DomainProdutoService;
import com.algaworks.algafood.domain.model.produto.ProdutoRepository;
import com.algaworks.algafood.domain.model.produto.ProdutoService;
import com.algaworks.algafood.domain.model.restaurante.DomainRestauranteService;
import com.algaworks.algafood.domain.model.restaurante.RestauranteRepository;
import com.algaworks.algafood.domain.model.restaurante.RestauranteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainServiceConfig {

    @Bean
    public CidadeService cidadeService(CidadeRepository cidadeRepository, EstadoRepository estadoRepository) {
        return new DomainCidadeService(cidadeRepository, estadoRepository);
    }

    @Bean
    public CozinhaService cozinhaService(CozinhaRepository repository, RestauranteRepository restauranteRepository) {
        return new DomainCozinhaService(repository, restauranteRepository);
    }

    @Bean
    public EstadoService estadoService(EstadoRepository estadoRepository, CidadeRepository cidadeRepository) {
        return new DomainEstadoService(estadoRepository, cidadeRepository);
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
    public RestauranteService restauranteService(
            RestauranteRepository restauranteRepository,
            CozinhaRepository cozinhaRepository
    ) {
        return new DomainRestauranteService(restauranteRepository, cozinhaRepository);
    }

    @Bean
    public ProdutoService produtoService(ProdutoRepository produtoRepository) {
        return new DomainProdutoService(produtoRepository);
    }
}
