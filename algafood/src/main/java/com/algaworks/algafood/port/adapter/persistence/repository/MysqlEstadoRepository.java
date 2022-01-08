package com.algaworks.algafood.port.adapter.persistence.repository;

import com.algaworks.algafood.domain.model.estado.Estado;
import com.algaworks.algafood.domain.model.estado.EstadoRepository;
import com.algaworks.algafood.port.adapter.persistence.model.EstadoModel;
import com.algaworks.algafood.port.adapter.service.EstadoTranslator;
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
public class MysqlEstadoRepository implements EstadoRepository {

    private EntityManager manager;
    private EstadoTranslator estadoTranslator;


    @Override
    public List<Estado> listar() {

        return manager.createQuery("SELECT e FROM EstadoModel e", EstadoModel.class)
                .getResultList()
                .stream()
                .map(model -> estadoTranslator.toEstadoFromEstadoModel(model))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void adicionar(Estado estado) {
        manager.merge(estadoTranslator.toEstadoModelFromEstado(estado));
    }

    @Override
    public Optional<Estado> buscar(String id) {
        return manager.createQuery("SELECT e FROM EstadoModel e WHERE e.id = ?1", EstadoModel.class)
                .setParameter(1, UUID.fromString(id))
                .getResultList()
                .stream()
                .map(model -> estadoTranslator.toEstadoFromEstadoModel(model))
                .findFirst();

    }

    @Override
    public Optional<Estado> buscarPeloNome(String nome) {
        return manager.createQuery("SELECT e FROM EstadoModel e WHERE e.nome = ?1", EstadoModel.class)
                .setParameter(1, nome)
                .getResultList()
                .stream()
                .map(model -> estadoTranslator.toEstadoFromEstadoModel(model))
                .findFirst();
    }

    @Transactional
    @Override
    public void atualizar(Estado estado) {
        manager.createQuery("UPDATE EstadoModel e SET e.nome = ?1  WHERE e.id = ?2")
                .setParameter(1, estado.getNome())
                .setParameter(2,  UUID.fromString(estado.getId()))
                .executeUpdate();
    }

    @Transactional
    @Override
    public void remover(Estado estado) {
        manager.createQuery("DELETE FROM EstadoModel e WHERE e.id = ?1")
                .setParameter(1, UUID.fromString(estado.getId()))
                .executeUpdate();
    }

    @Override
    public boolean existeEstadoComNome(String nome) {
        return  manager.createQuery(
                "select case when count(e)> 0 then true else false " +
                        "end from EstadoModel e where lower(e.nome) like lower(?1)", Boolean.class)
                .setParameter(1, nome)
                .getSingleResult();
    }

    @Override
    public boolean existeEstadoComNomeComIdDiferente(String nome, String id) {
        return manager.createQuery(
                        "select case when count(e)> 0 then true else false " +
                                "end from EstadoModel e where lower(e.nome) like lower(?1) " +
                                "and e.id <> ?2", Boolean.class)
                .setParameter(1, nome)
                .setParameter(2, UUID.fromString(id))
                .getSingleResult();
    }


}
