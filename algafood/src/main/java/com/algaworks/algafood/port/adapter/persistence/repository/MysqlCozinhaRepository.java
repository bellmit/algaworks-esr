package com.algaworks.algafood.port.adapter.persistence.repository;

import com.algaworks.algafood.domain.model.cozinha.Cozinha;
import com.algaworks.algafood.domain.model.cozinha.CozinhaRepository;
import com.algaworks.algafood.port.adapter.persistence.model.CozinhaModel;
import com.algaworks.algafood.port.adapter.service.CozinhaTranslator;
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
public class MysqlCozinhaRepository implements CozinhaRepository {

    private EntityManager manager;
    private CozinhaTranslator cozinhaTranslator;


    @Override
    public List<Cozinha> listar() {

        return manager.createQuery("SELECT c FROM CozinhaModel c", CozinhaModel.class)
                .getResultList()
                .stream()
                .map(model -> cozinhaTranslator.toCozinhaFromCozinhaModel(model))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void adicionar(Cozinha cozinha) {
        manager.merge(cozinhaTranslator.toCozinhaModelFromCozinha(cozinha));
    }

    @Override
    public Optional<Cozinha> buscar(String id) {
        return manager.createQuery("SELECT c FROM CozinhaModel c WHERE c.id = ?1", CozinhaModel.class)
                .setParameter(1, UUID.fromString(id))
                .getResultList()
                .stream()
                .map(model -> cozinhaTranslator.toCozinhaFromCozinhaModel(model))
                .findFirst();

    }

    @Override
    public Optional<Cozinha> buscarPeloNome(String nome) {
        return manager.createQuery("SELECT c FROM CozinhaModel c WHERE c.nome = ?1", CozinhaModel.class)
                .setParameter(1, nome)
                .getResultList()
                .stream()
                .map(model -> cozinhaTranslator.toCozinhaFromCozinhaModel(model))
                .findFirst();
    }

    @Transactional
    @Override
    public void atualizar(Cozinha cozinha) {
        manager.createQuery("UPDATE CozinhaModel c SET c.nome = ?1  WHERE c.id = ?2")
                .setParameter(1, cozinha.getNome())
                .setParameter(2,  UUID.fromString(cozinha.getId()))
                .executeUpdate();
    }

    @Transactional
    @Override
    public void remover(Cozinha cozinha) {
        manager.createQuery("DELETE FROM CozinhaModel c WHERE c.id = ?1")
                .setParameter(1, UUID.fromString(cozinha.getId()))
                .executeUpdate();
    }

    @Override
    public boolean existeCozinhaComNome(String nome) {
        return  manager.createQuery(
                "select case when count(c)> 0 then true else false " +
                        "end from CozinhaModel c where lower(c.nome) like lower(?1)", Boolean.class)
                .setParameter(1, nome)
                .getSingleResult();
    }

    @Override
    public boolean existeCozinhaComNomeComIdDiferente(String nome, String id) {
        return manager.createQuery(
                        "select case when count(c)> 0 then true else false " +
                                "end from CozinhaModel c where lower(c.nome) like lower(?1) " +
                                "and c.id <> ?2", Boolean.class)
                .setParameter(1, nome)
                .setParameter(2, UUID.fromString(id))
                .getSingleResult();
    }


}
