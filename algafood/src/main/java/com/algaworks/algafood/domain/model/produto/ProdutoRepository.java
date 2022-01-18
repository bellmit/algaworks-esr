package com.algaworks.algafood.domain.model.produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {
    List<Produto> listar();
    void adicionar(Produto produto);
    Optional<Produto> buscar(ProdutoId produtoId);
    void atualizar(Produto produto);
    void remover(ProdutoId produtoId);
    boolean existeProdutoComId(ProdutoId produtoId);
}
