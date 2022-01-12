package com.algaworks.algafood.domain.model.formapagamento;


import com.algaworks.algafood.domain.model.formapagamento.FormaPagamento;

import java.util.List;
import java.util.UUID;

public interface FormaPagamentoService {
    List<FormaPagamento> listar();
    void adicionar(FormaPagamento formaPagamento);
    FormaPagamento buscar(UUID id);
    void atualizar(FormaPagamento formaPagamento);
    void remover(FormaPagamento formaPagamento);
}
