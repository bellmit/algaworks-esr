package com.algaworks.algafood.domain.model.produto;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DomainProdutoService implements ProdutoService{

    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> listar() {
        return produtoRepository.listar();
    }

    @Override
    public void adicionar(Produto produto) {
        produtoRepository.adicionar(produto);
    }

    @Override
    public Produto buscar(ProdutoId produtoId) {
        return produtoRepository.buscar(produtoId)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(produtoId.getId()));
    }

    @Override
    public void atualizar(Produto produto) {
        if (!produtoRepository.existeProdutoComId(produto.getProdutoId())) {
            throw new ProdutoNaoEncontradoException(produto.getProdutoId().getId());
        }

        produtoRepository.atualizar(produto);
    }

    @Override
    public void remover(ProdutoId produtoId) {
        if (!produtoRepository.existeProdutoComId(produtoId)) {
            throw new ProdutoNaoEncontradoException(produtoId.getId());
        }

        produtoRepository.remover(produtoId);
    }
}
