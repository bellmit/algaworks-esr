package com.algaworks.algafood.infrastructure.persistence.model.formapagamento;

import com.algaworks.algafood.domain.model.formapagamento.FormaPagamento;
import com.algaworks.algafood.domain.model.formapagamento.FormaPagamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MysqlFormaPagamentoRepository implements FormaPagamentoRepository {

    private EntityManager manager;
    private FormaPagmentoTranslator formaPagmentoTranslator;


    @Override
    public List<FormaPagamento> listar() {

        return manager.createQuery("SELECT fp FROM FormaPagamentoModel fp", FormaPagamentoModel.class)
                .getResultList()
                .stream()
                .map(model -> formaPagmentoTranslator.toFormaPagamentoFromFormaPagamentoModel(model))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void adicionar(FormaPagamento formaPagamento) {
        manager.merge(formaPagmentoTranslator.toFormaPagamentoModelFromFormaPagamento(formaPagamento));
    }

    @Override
    public Optional<FormaPagamento> buscar(UUID id) {
        return manager.createQuery("SELECT fp FROM FormaPagamentoModel fp WHERE fp.id = ?1", FormaPagamentoModel.class)
                .setParameter(1, id)
                .getResultList()
                .stream()
                .map(model -> formaPagmentoTranslator.toFormaPagamentoFromFormaPagamentoModel(model))
                .findFirst();

    }

    @Override
    public Optional<FormaPagamento> buscarPelaDescricao(String descricao) {
        return manager.createQuery("SELECT fp FROM FormaPagamentoModel fp WHERE fp.descricao = ?1", FormaPagamentoModel.class)
                .setParameter(1, descricao)
                .getResultList()
                .stream()
                .map(model -> formaPagmentoTranslator.toFormaPagamentoFromFormaPagamentoModel(model))
                .findFirst();
    }

    @Transactional
    @Override
    public void atualizar(FormaPagamento formaPagamento) {
        manager.createQuery("UPDATE FormaPagamentoModel fp SET fp.descricao = ?1  WHERE fp.id = ?2")
                .setParameter(1, formaPagamento.getDescricao())
                .setParameter(2,  formaPagamento.getId())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void remover(FormaPagamento formaPagamento) {
        manager.createQuery("DELETE FROM FormaPagamentoModel fp WHERE fp.id = ?1")
                .setParameter(1, formaPagamento.getId())
                .executeUpdate();
    }

    @Override
    public boolean existeFormaPagamentoComDescricao(String descricao) {
        return  manager.createQuery(
                "select case when count(fp)> 0 then true else false " +
                        "end from FormaPagamentoModel fp where lower(fp.descricao) like lower(?1)", Boolean.class)
                .setParameter(1, descricao)
                .getSingleResult();
    }

    @Override
    public boolean existeFormaPagamentoComDescricaoComIdDiferente(String descricao, UUID id) {
        return manager.createQuery(
                        "select case when count(fp)> 0 then true else false " +
                                "end from FormaPagamentoModel fp where lower(fp.descricao) like lower(?1) " +
                                "and fp.id <> ?2", Boolean.class)
                .setParameter(1, descricao)
                .setParameter(2, id)
                .getSingleResult();
    }


}
