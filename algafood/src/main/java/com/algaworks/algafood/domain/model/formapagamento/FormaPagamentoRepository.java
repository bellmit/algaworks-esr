package com.algaworks.algafood.domain.model.formapagamento;

import com.algaworks.algafood.domain.model.formapagamento.FormaPagamento;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FormaPagamentoRepository {
    List<FormaPagamento> listar();
    void adicionar(FormaPagamento formaPagamento);
    Optional<FormaPagamento> buscar(UUID id);
    Optional<FormaPagamento> buscarPelaDescricao(String descricao);
    void atualizar(FormaPagamento formaPagamento);
    void remover(FormaPagamento formaPagamento);
    boolean existeFormaPagamentoComDescricao(String descricao);
    boolean existeFormaPagamentoComDescricaoComIdDiferente(String descricao, UUID id);
}
