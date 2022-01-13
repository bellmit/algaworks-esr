package com.algaworks.algafood.infrastructure.persistence.model.cidade;

import com.algaworks.algafood.domain.model.cidade.Cidade;
import com.algaworks.algafood.domain.model.cidade.CidadeId;
import com.algaworks.algafood.domain.model.cidade.CidadeRepository;
import com.algaworks.algafood.domain.model.estado.EstadoId;
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
    public Optional<Cidade> buscar(CidadeId cidadeId) {
        return manager.createQuery("SELECT c FROM CidadeModel c WHERE c.id = ?1", CidadeModel.class)
                .setParameter(1, cidadeId.getId())
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
                .setParameter(2,  cidade.getCidadeId().getId())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void remover(CidadeId cidadeId) {
        manager.createQuery("DELETE FROM CidadeModel c WHERE c.id = ?1")
                .setParameter(1, cidadeId.getId())
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
    public boolean existeCidadeComNomeComIdDiferente(String nome, CidadeId cidadeId) {
        return manager.createQuery(
                        "select case when count(c)> 0 then true else false " +
                                "end from CidadeModel c where lower(c.nome) like lower(?1) " +
                                "and c.id <> ?2", Boolean.class)
                .setParameter(1, nome)
                .setParameter(2, cidadeId.getId())
                .getSingleResult();
    }

    @Override
    public boolean existeCidadeComId(CidadeId cidadeId) {
        return manager.createQuery(
                        "select case when count(c)> 0 then true else false " +
                                "end from CidadeModel c where c.id = ?1", Boolean.class)
                .setParameter(1, cidadeId.getId())
                .getSingleResult();
    }

    @Override
    public boolean existeCidadeComEstadoId(EstadoId estadoId) {
        return manager.createQuery(
                        "select case when count(c)> 0 then true else false " +
                                "end from CidadeModel c where c.estado.id = ?1", Boolean.class)
                .setParameter(1, estadoId.getId())
                .getSingleResult();
    }


}
