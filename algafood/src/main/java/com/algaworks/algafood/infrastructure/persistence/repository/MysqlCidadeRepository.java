package com.algaworks.algafood.infrastructure.persistence.repository;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.infrastructure.persistence.model.CidadeModel;
import com.algaworks.algafood.infrastructure.persistence.service.CidadeTranslator;
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
public class MysqlCidadeRepository implements CidadeRepository {

    private EntityManager manager;
    private CidadeTranslator cidadeTranslator;


    @Override
    public List<Cidade> listar() {

        return manager.createQuery("SELECT c FROM CidadeModel c", CidadeModel.class)
                .getResultList()
                .stream()
                .map(model -> cidadeTranslator.toCidadeFromCidadeModel(model))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void adicionar(Cidade cidade) {
        manager.merge(cidadeTranslator.toCidadeModelFromCidade(cidade));
    }

    @Override
    public Optional<Cidade> buscar(UUID id) {
        return manager.createQuery("SELECT c FROM CidadeModel c WHERE c.id = ?1", CidadeModel.class)
                .setParameter(1, id)
                .getResultList()
                .stream()
                .map(model -> cidadeTranslator.toCidadeFromCidadeModel(model))
                .findFirst();

    }

    @Override
    public Optional<Cidade> buscarPeloNome(String nome) {
        return manager.createQuery("SELECT c FROM CidadeModel c WHERE c.nome = ?1", CidadeModel.class)
                .setParameter(1, nome)
                .getResultList()
                .stream()
                .map(model -> cidadeTranslator.toCidadeFromCidadeModel(model))
                .findFirst();
    }

    @Transactional
    @Override
    public void atualizar(Cidade cidade) {
        manager.createQuery("UPDATE CidadeModel c SET c.nome = ?1  WHERE c.id = ?2")
                .setParameter(1, cidade.getNome())
                .setParameter(2,  cidade.getId())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void remover(Cidade cidade) {
        manager.createQuery("DELETE FROM CidadeModel c WHERE c.id = ?1")
                .setParameter(1, cidade.getId())
                .executeUpdate();
    }

    @Override
    public boolean existeCidadeComNome(String nome) {
        return  manager.createQuery(
                "select case when count(c)> 0 then true else false " +
                        "end from CidadeModel c where lower(c.nome) like lower(?1)", Boolean.class)
                .setParameter(1, nome)
                .getSingleResult();
    }

    @Override
    public boolean existeCidadeComNomeComIdDiferente(String nome, UUID id) {
        return manager.createQuery(
                        "select case when count(c)> 0 then true else false " +
                                "end from CidadeModel c where lower(c.nome) like lower(?1) " +
                                "and c.id <> ?2", Boolean.class)
                .setParameter(1, nome)
                .setParameter(2, id)
                .getSingleResult();
    }


}
