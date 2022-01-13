package com.algaworks.algafood.domain.model.formapagamento;


import java.util.List;

public interface FormaPagamentoService {
    List<FormaPagamento> listar();
    void adicionar(FormaPagamento formaPagamento);
    FormaPagamento buscar(FormaPagamentoId formaPagamentoId);
    void atualizar(FormaPagamento formaPagamento);
    void remover(FormaPagamentoId formaPagamentoId);
}
