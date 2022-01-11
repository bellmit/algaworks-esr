package com.algaworks.algafood.infrastructure.persistence.repository;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.infrastructure.persistence.service.CozinhaTranslator;
import com.algaworks.algafood.infrastructure.persistence.model.CozinhaModel;
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
    public Optional<Cozinha> buscar(UUID id) {
        return manager.createQuery("SELECT c FROM CozinhaModel c WHERE c.id = ?1", CozinhaModel.class)
                .setParameter(1, id)
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
                .setParameter(2, cozinha.getId())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void remover(Cozinha cozinha) {
        manager.createQuery("DELETE FROM CozinhaModel c WHERE c.id = ?1")
                .setParameter(1, cozinha.getId())
                .executeUpdate();
    }

    @Override
    public boolean existeCozinhaComId(UUID id) {
        return manager.createQuery(
                        "select case when count(c)> 0 then true else false " +
                                "end from CozinhaModel c where c.id = ?1", Boolean.class)
                .setParameter(1, id)
                .getSingleResult();
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
    public boolean existeCozinhaComNomeComIdDiferente(String nome, UUID id) {
        return manager.createQuery(
                        "select case when count(c)> 0 then true else false " +
                                "end from CozinhaModel c where lower(c.nome) like lower(?1) " +
                                "and c.id <> ?2", Boolean.class)
                .setParameter(1, nome)
                .setParameter(2, id)
                .getSingleResult();
    }


}
