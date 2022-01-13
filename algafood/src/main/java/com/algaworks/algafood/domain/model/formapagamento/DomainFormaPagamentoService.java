package com.algaworks.algafood.domain.model.formapagamento;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DomainFormaPagamentoService implements FormaPagamentoService {
    private FormaPagamentoRepository formaPagamentoRepository;

    @Override
    public List<FormaPagamento> listar() {
        return formaPagamentoRepository.listar();
    }

    @Override
    public void adicionar(FormaPagamento formaPagamento) {
        if (formaPagamentoRepository.existeFormaPagamentoComDescricao(formaPagamento.getDescricao())) {
            throw new FormaPagamentoEmUsoException(formaPagamento.getDescricao());
        }

        this.formaPagamentoRepository.adicionar(formaPagamento);

    }

    @Override
    public FormaPagamento buscar(FormaPagamentoId formaPagamentoId) {
        return this.formaPagamentoRepository.buscar(formaPagamentoId)
                .orElseThrow(() -> new FormaPagamentoNaoEncontradaException(formaPagamentoId.getId()));
    }

    @Override
    public void atualizar(FormaPagamento formaPagamento) {
        if (this.formaPagamentoRepository.existeFormaPagamentoComDescricaoComIdDiferente(
                formaPagamento.getDescricao(), formaPagamento.getFormaPagamentoId())
        ) {
            throw new FormaPagamentoEmUsoException(formaPagamento.getDescricao());
        }

        this.formaPagamentoRepository.atualizar(formaPagamento);
    }

    @Override
    public void remover(FormaPagamentoId formaPagamentoId) {
        if(!formaPagamentoRepository.existeFormaPagamentoComId(formaPagamentoId)) {
            new FormaPagamentoNaoEncontradaException(formaPagamentoId.getId());
        }
        formaPagamentoRepository.remover(formaPagamentoId);
    }
}
