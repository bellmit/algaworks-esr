package com.algaworks.algafood.infrastructure.persistence.database.mysql.service;

import com.algaworks.algafood.domain.model.produto.Produto;
import com.algaworks.algafood.domain.model.produto.ProdutoId;
import com.algaworks.algafood.domain.model.restaurante.RestauranteId;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.ProdutoModel;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.RestauranteModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProdutoTranslator {

    public ProdutoModel toProdutoModel(Produto produto) {
        RestauranteModel restauranteModel = new RestauranteModel();
        restauranteModel.setId(produto.getRestauranteId().getId());

        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setId(produto.getProdutoId().getId());
        produtoModel.setNome(produtoModel.getNome());
        produtoModel.setDescricao(produto.getDescricao());
        produtoModel.setPreco(produto.getPreco());
        produtoModel.setAtivo(produto.getAtivo());
        produtoModel.setRestaurante(restauranteModel);

        return produtoModel;
    }

    public Set<ProdutoModel> toCollectionProdutoModel(Set<ProdutoId> ids) {
        return ids.stream()
                .map(id -> {
                    ProdutoModel produtoModel = new ProdutoModel();
                    produtoModel.setId(id.getId());
                    return produtoModel;
                }).collect(Collectors.toSet());
    }

    public Produto toProduto(ProdutoModel produtoModel) {
        return new Produto(
                new ProdutoId(produtoModel.getId()),
                produtoModel.getNome(),
                produtoModel.getDescricao(),
                produtoModel.getPreco(),
                produtoModel.getAtivo(),
                new RestauranteId(produtoModel.getRestaurante().getId())
        );
    }
}
