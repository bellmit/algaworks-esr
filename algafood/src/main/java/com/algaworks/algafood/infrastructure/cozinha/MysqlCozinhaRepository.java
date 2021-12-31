package com.algaworks.algafood.infrastructure.cozinha;

import com.algaworks.algafood.domain.cozinha.Cozinha;
import com.algaworks.algafood.domain.cozinha.CozinhaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Component
public class MysqlCozinhaRepository implements CozinhaRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cozinha> listarTodas() {
        List<Cozinha> cozinhas = new ArrayList<>();

        manager.createQuery("from CozinhaModel", CozinhaModel.class)
                .getResultList()
                .forEach( cozinhaModel -> {
                    cozinhas.add( new Cozinha(cozinhaModel.getNome()));
                });

        return cozinhas;
    }
}
