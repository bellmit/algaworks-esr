package com.algaworks.algafood.infrastructure.persistence.database.mysql.repository;

import com.algaworks.algafood.domain.model.produto.Produto;
import com.algaworks.algafood.domain.model.produto.ProdutoId;
import com.algaworks.algafood.domain.model.produto.ProdutoRepository;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.ProdutoModel;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.service.ProdutoTranslator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MysqlProdutoRepository implements ProdutoRepository {

    private SpringDataProdutoRepository produtoRepository;
    private ProdutoTranslator translator;

    @Override
    public List<Produto> listar() {
        return produtoRepository.findAll()
                .stream()
                .map(produtoModel -> translator.toProduto(produtoModel))
                .collect(Collectors.toList());
    }

    @Override
    public void adicionar(Produto produto) {
        ProdutoModel produtoModel = translator.toProdutoModel(produto);
        produtoRepository.save(produtoModel);
    }

    @Override
    public Optional<Produto> buscar(ProdutoId produtoId) {
        return produtoRepository.findById(produtoId.getId())
                .stream()
                .map(produtoModel -> translator.toProduto(produtoModel))
                .findFirst();
    }

    @Override
    public void atualizar(Produto produto) {
        ProdutoModel produtoModel = translator.toProdutoModel(produto);
        produtoRepository.save(produtoModel);
    }

    @Override
    public void remover(ProdutoId produtoId) {
        produtoRepository.deleteById(produtoId.getId());
    }

    @Override
    public boolean existeProdutoComId(ProdutoId produtoId) {
        return produtoRepository.existsById(produtoId.getId());
    }
}
