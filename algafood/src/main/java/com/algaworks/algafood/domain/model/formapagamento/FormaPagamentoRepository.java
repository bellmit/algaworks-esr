package com.algaworks.algafood.domain.model.formapagamento;

import java.util.List;
import java.util.Optional;

public interface FormaPagamentoRepository {
    List<FormaPagamento> listar();
    void adicionar(FormaPagamento formaPagamento);
    Optional<FormaPagamento> buscar(String id);
    Optional<FormaPagamento> buscarPelaDescricao(String descricao);
    void atualizar(FormaPagamento formaPagamento);
    void remover(FormaPagamento formaPagamento);
    boolean existeFormaPagamentoComDescricao(String descricao);
    boolean existeFormaPagamentoComDescricaoComIdDiferente(String descricao, String id);
}
