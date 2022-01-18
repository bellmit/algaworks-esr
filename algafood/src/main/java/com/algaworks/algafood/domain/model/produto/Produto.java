package com.algaworks.algafood.domain.model.produto;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import com.algaworks.algafood.domain.model.restaurante.RestauranteId;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

@Getter
public class Produto {

    private ProdutoId produtoId;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Boolean ativo;
    private RestauranteId restauranteId;

    public Produto(
            ProdutoId produtoId,
            String nome,
            String descricao,
            BigDecimal preco,
            Boolean ativo,
            RestauranteId restauranteId) {

        this.setProdutoId(produtoId);
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setPreco(preco);
        this.setAtivo(ativo);
        this.setRestauranteId(restauranteId);
    }

    public void ativar() {
        this.setAtivo(true);
    }

    public void desativar() {
        this.setAtivo(false);
    }

    private void setProdutoId(ProdutoId produtoId) {
        if (produtoId == null) {
            throw new PropriedadeInvalidaException(Produto.class, "produto", "deve ser informado");
        }

        this.produtoId = produtoId;
    }

    private void setNome(String nome) {
        if (!StringUtils.hasText(nome)) {
            throw new PropriedadeInvalidaException(Produto.class, "nome", "deve ser informado");
        }

        this.nome = nome;
    }

    private void setDescricao(String descricao) {
        if (!StringUtils.hasText(descricao)) {
            throw new PropriedadeInvalidaException(Produto.class, "descricao", "deve ser informado");
        }

        this.descricao = descricao;
    }

    private void setPreco(BigDecimal preco) {
        if (preco == null) {
            throw new PropriedadeInvalidaException(Produto.class, "preco", "deve ser informado");
        }

        if (preco.equals(BigDecimal.ZERO)) {
            throw new PropriedadeInvalidaException(Produto.class, "preco", "nao pode ser zero");
        }

        this.preco = preco;
    }

    private void setAtivo(Boolean ativo) {
        if (ativo == null) {
            throw new PropriedadeInvalidaException(Produto.class, "ativo", "deve ser informado");
        }
        this.ativo = ativo;
    }

    private void setRestauranteId(RestauranteId restauranteId) {
        if (restauranteId == null) {
            throw new PropriedadeInvalidaException(Produto.class, "restauranteId", "deve ser informado");
        }

        this.restauranteId = restauranteId;
    }
}
