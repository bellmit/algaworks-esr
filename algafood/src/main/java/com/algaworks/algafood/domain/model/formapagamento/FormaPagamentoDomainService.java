package com.algaworks.algafood.domain.model.formapagamento;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class FormaPagamentoDomainService {
    private FormaPagamentoRepository formaPagamentoRepository;

    public List<FormaPagamento> listar() {
        return formaPagamentoRepository.listar();
    }

    public void adicionar(FormaPagamento formaPagamento) {
        if(formaPagamentoRepository.existeFormaPagamentoComDescricao(formaPagamento.getDescricao())) {
            throw new EntidadeEmUsoException(
                    "Ja existe uma forma de pagamento cadastrada com a Descricao: " + formaPagamento.getDescricao());
        }

        this.formaPagamentoRepository.adicionar(formaPagamento);

    }

    public FormaPagamento buscar(String id) {
        return this.formaPagamentoRepository.buscar(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Nao foi possivel encontrar uma forma de pagamento de id: " + id
                ));
    }

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

    public void remover(FormaPagamento formaPagamento) {
        formaPagamentoRepository.remover(formaPagamento);
    }
}
