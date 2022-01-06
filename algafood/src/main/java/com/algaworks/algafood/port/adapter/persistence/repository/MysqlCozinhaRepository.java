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
    public Cozinha buscar(String nome) {
        return manager.createQuery("SELECT c FROM CozinhaModel c WHERE c.nome = ?1", CozinhaModel.class)
                .setParameter(1, nome)
                .getResultList()
                .stream()
                .map(model -> cozinhaTranslator.toCozinhaFromCozinhaModel(model))
                .findFirst()
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Nao foi possivel encontrar uma cozinha de nome " + nome
                ));
    }


}
