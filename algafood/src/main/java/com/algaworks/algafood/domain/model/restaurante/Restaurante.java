package com.algaworks.algafood.domain.model.restaurante;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import com.algaworks.algafood.domain.model.cozinha.CozinhaId;
import com.algaworks.algafood.domain.model.endereco.Endereco;
import com.algaworks.algafood.domain.model.formapagamento.FormaPagamento;
import com.algaworks.algafood.domain.model.formapagamento.FormaPagamentoId;
import com.algaworks.algafood.domain.model.produto.ProdutoId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurante {
    @EqualsAndHashCode.Include
    private RestauranteId restauranteId;
    private String nome;
    private BigDecimal taxaFrete;
    private CozinhaId cozinhaId;
    private Set<FormaPagamentoId> formaPagamentos;
    private Endereco endereco;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;
    private Set<ProdutoId> produtos;

    public Restaurante(RestauranteId restauranteId, String nome, BigDecimal taxaFrete, CozinhaId cozinhaId) {
        this();
        this.setRestauranteId(restauranteId);
        this.setNome(nome);
        this.setTaxaFrete(taxaFrete);
        this.setCozinhaId(cozinhaId);
    }

    public Restaurante(
            RestauranteId restauranteId,
            String nome,
            BigDecimal taxaFrete,
            CozinhaId cozinhaId,
            LocalDateTime dataCadastro,
            LocalDateTime dataAtualizacao
    ) {
        this(restauranteId, nome, taxaFrete, cozinhaId);
        this.setDataCadastro(dataCadastro);
        this.setDataAtualizacao(dataAtualizacao);
    }

    private Restaurante() {
        this.formaPagamentos = new HashSet<>();
        this.dataCadastro = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
        this.produtos = new HashSet<>();
    }

    public void adicionarProduto(ProdutoId produtoId) {
        if(produtoId != null) {
            this.produtos.add(produtoId);
        }
    }

    public void adicionarFormaPagamento(FormaPagamentoId formaPagamentoId) {
        if (formaPagamentoId != null) {
            this.formaPagamentos.add(formaPagamentoId);
        }
    }

    public void adicionarEndereco(Endereco endereco) {
        this.setEndereco(endereco);
    }

    public void atualizarDataAtualizacao() {
        this.setDataAtualizacao(LocalDateTime.now());
    }

    private void setRestauranteId(RestauranteId restauranteId) {
        if (restauranteId == null) {
            throw new PropriedadeInvalidaException(Restaurante.class, "restauranteId", "deve ser informado");
        }

        this.restauranteId = restauranteId;
    }

    private void setNome(String nome) {
        if (!StringUtils.hasText(nome)) {
            throw new PropriedadeInvalidaException(Restaurante.class, "nome", "deve ser informado");
        }

        this.nome = nome;
    }

    private void setTaxaFrete(BigDecimal taxaFrete) {
        if (taxaFrete == null || taxaFrete.equals(BigDecimal.ZERO)) {
            throw new PropriedadeInvalidaException(Restaurante.class, "taxaFrete", "deve ser maior que zero");
        }

        this.taxaFrete = taxaFrete;
    }

    private void setCozinhaId(CozinhaId cozinhaId) {
        if (cozinhaId == null) {
            throw new PropriedadeInvalidaException(Restaurante.class, "cozinhaId", "deve ser informado");
        }

        this.cozinhaId = cozinhaId;
    }

    private void setEndereco(Endereco endereco) {
        if (endereco == null) {
            throw new PropriedadeInvalidaException(Restaurante.class, "endereco", "deve ser informado");
        }
        this.endereco = endereco;
    }

    private void setDataCadastro(LocalDateTime dataCadastro) {
        if (dataCadastro == null) {
            throw new PropriedadeInvalidaException(Restaurante.class, "dataCadastro", "deve ser informado");
        }
        this.dataCadastro = dataCadastro;
    }

    private void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        if (dataAtualizacao == null) {
            throw new PropriedadeInvalidaException(Restaurante.class, "dataAtualizacao", "deve ser informado");
        }
        this.dataAtualizacao = dataAtualizacao;
    }

}
