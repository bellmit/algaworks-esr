package com.algaworks.algafood.domain.model.produto;

import java.util.List;

public interface ProdutoService {
    List<Produto> listar();
    void adicionar(Produto produto);
    Produto buscar(ProdutoId produtoId);
    void atualizar(Produto produto);
    void remover(ProdutoId produtoId);
}
