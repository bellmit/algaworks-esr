package com.algaworks.algafood.infrastructure.persistence.model.formapagamento;

import com.algaworks.algafood.domain.model.formapagamento.FormaPagamento;
import com.algaworks.algafood.domain.model.formapagamento.FormaPagamentoId;
import com.algaworks.algafood.domain.model.formapagamento.FormaPagamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MysqlFormaPagamentoRepository implements FormaPagamentoRepository {

    private FormaPagmentoTranslator formaPagmentoTranslator;
    private SpringDataFormaPagamentoRepository formaPagamentoRepository;

    @Override
    public List<FormaPagamento> listar() {
        return formaPagamentoRepository.findAll()
                .stream()
                .map(model -> formaPagmentoTranslator.toFormaPagamento(model))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void adicionar(FormaPagamento formaPagamento) {
        formaPagamentoRepository.save(formaPagmentoTranslator.toFormaPagamentoModel(formaPagamento));
    }

    @Override
    public Optional<FormaPagamento> buscar(FormaPagamentoId formaPagamentoId) {
        return formaPagamentoRepository.findById(formaPagamentoId.getId())
                .stream()
                .map(model -> formaPagmentoTranslator.toFormaPagamento(model))
                .findFirst();

    }

    @Override
    public Optional<FormaPagamento> buscarPelaDescricao(String descricao) {
        return formaPagamentoRepository.findByDescricao(descricao)
                .stream()
                .map(model -> formaPagmentoTranslator.toFormaPagamento(model))
                .findFirst();
    }

    @Transactional
    @Override
    public void atualizar(FormaPagamento formaPagamento) {
        FormaPagamentoModel formaPagamentoModel = formaPagmentoTranslator
                .toFormaPagamentoModel(formaPagamento);
        formaPagamentoRepository.save(formaPagamentoModel);
    }

    @Transactional
    @Override
    public void remover(FormaPagamentoId formaPagamentoId) {
        formaPagamentoRepository.deleteById(formaPagamentoId.getId());
    }

    @Override
    public boolean existeFormaPagamentoComDescricao(String descricao) {
        return formaPagamentoRepository.existsByDescricao(descricao);
    }

    @Override
    public boolean existeFormaPagamentoComDescricaoComIdDiferente(String descricao, FormaPagamentoId formaPagamentoId) {
        return formaPagamentoRepository.existsByDescricaoAndIdNot(
                descricao,
                formaPagamentoId.getId()
        );
    }

    @Override
    public boolean existeFormaPagamentoComId(FormaPagamentoId formaPagamentoId) {
        return formaPagamentoRepository.existsById(formaPagamentoId.getId());
    }


}
