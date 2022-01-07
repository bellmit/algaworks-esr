package com.algaworks.algafood.port.adapter.persistence.repository;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
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
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MysqlCozinhaRepository implements CozinhaRepository {

    private EntityManager manager;
    private CozinhaTranslator cozinhaTranslator;


    @Override
    public List<Cozinha> listar() {

        return manager.createQuery("from CozinhaModel", CozinhaModel.class)
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
    public Optional<Cozinha> buscar(String codigo) {
        return manager.createQuery("SELECT c FROM CozinhaModel c WHERE c.id = ?1", CozinhaModel.class)
                .setParameter(1, codigo)
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
                .setParameter(2, cozinha.getCodigo())
                .executeUpdate();
    }


}
