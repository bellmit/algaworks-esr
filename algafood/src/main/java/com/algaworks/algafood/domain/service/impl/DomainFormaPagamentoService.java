package com.algaworks.algafood.domain.service.impl;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;
import com.algaworks.algafood.domain.service.FormaPagamentoService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class DomainFormaPagamentoService implements FormaPagamentoService {
    private FormaPagamentoRepository formaPagamentoRepository;

    @Override
    public List<FormaPagamento> listar() {
        return formaPagamentoRepository.listar();
    }

    @Override
    public void adicionar(FormaPagamento formaPagamento) {
        if(formaPagamentoRepository.existeFormaPagamentoComDescricao(formaPagamento.getDescricao())) {
            throw new EntidadeEmUsoException(
                    "Ja existe uma forma de pagamento cadastrada com a Descricao: " + formaPagamento.getDescricao());
        }

        this.formaPagamentoRepository.adicionar(formaPagamento);

    }

    @Override
    public FormaPagamento buscar(UUID id) {
        return this.formaPagamentoRepository.buscar(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Nao foi possivel encontrar uma forma de pagamento de id: " + id
                ));
    }

    @Override
    public void atualizar(FormaPagamento formaPagamento) {
        if (this.formaPagamentoRepository.existeFormaPagamentoComDescricaoComIdDiferente(
                formaPagamento.getDescricao(), formaPagamento.getId())
        ) {
            throw new EntidadeEmUsoException(
                    "Ja existe um cozinha cadastrada com o nome: " + formaPagamento.getDescricao()
            );
        }

        this.formaPagamentoRepository.atualizar(formaPagamento);
    }

    @Override
    public void remover(FormaPagamento formaPagamento) {
        formaPagamentoRepository.remover(formaPagamento);
    }
}
