package com.algaworks.algafood.infrastructure.persistence.model.permissao;

import com.algaworks.algafood.domain.model.permissao.Permissao;
import com.algaworks.algafood.domain.model.permissao.PermissaoId;
import com.algaworks.algafood.domain.model.permissao.PermissaoRepository;
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
public class MysqlPermissaoRepository implements PermissaoRepository {

    private EntityManager manager;
    private PermissaoTranslator permissaoTranslator;


    @Override
    public List<Permissao> listar() {

        return manager.createQuery("SELECT p FROM PermissaoModel p", PermissaoModel.class)
                .getResultList()
                .stream()
                .map(model -> permissaoTranslator.toPermissaoFromPermissaoModel(model))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void adicionar(Permissao permissao) {
        manager.merge(permissaoTranslator.toPermissaoModelFromPermissao(permissao));
    }

    @Override
    public Optional<Permissao> buscar(PermissaoId permissaoId) {
        return manager.createQuery("SELECT p FROM PermissaoModel p WHERE p.id = ?1", PermissaoModel.class)
                .setParameter(1, permissaoId.getId())
                .getResultList()
                .stream()
                .map(model -> permissaoTranslator.toPermissaoFromPermissaoModel(model))
                .findFirst();

    }

    @Override
    public Optional<Permissao> buscarPeloNome(String nome) {
        return manager.createQuery("SELECT p FROM PermissaoModel p WHERE p.nome = ?1", PermissaoModel.class)
                .setParameter(1, nome)
                .getResultList()
                .stream()
                .map(model -> permissaoTranslator.toPermissaoFromPermissaoModel(model))
                .findFirst();
    }

    @Transactional
    @Override
    public void atualizar(Permissao permissao) {
        manager.createQuery("UPDATE PermissaoModel p SET p.nome = ?1, p.descricao = ?2  WHERE p.id = ?3")
                .setParameter(1, permissao.getNome())
                .setParameter(2, permissao.getDescricao())
                .setParameter(3, permissao.getPermissaoId().getId())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void remover(PermissaoId permissaoId) {
        manager.createQuery("DELETE FROM PermissaoModel p WHERE p.id = ?1")
                .setParameter(1, permissaoId.getId())
                .executeUpdate();
    }

    @Override
    public boolean existePermissaoComNome(String nome) {
        return manager.createQuery(
                        "select case when count(p)> 0 then true else false " +
                                "end from PermissaoModel p where lower(p.nome) like lower(?1)", Boolean.class)
                .setParameter(1, nome)
                .getSingleResult();
    }

    @Override
    public boolean existePermissaoComNomeComIdDiferente(String nome, PermissaoId permissaoId) {
        return manager.createQuery(
                        "select case when count(p)> 0 then true else false " +
                                "end from PermissaoModel p where lower(p.nome) like lower(?1) " +
                                "and p.id <> ?2", Boolean.class)
                .setParameter(1, nome)
                .setParameter(2, permissaoId.getId())
                .getSingleResult();
    }

    @Override
    public boolean existePermissaoComId(PermissaoId permissaoId) {
        return manager.createQuery(
                        "select case when count(p)> 0 then true else false " +
                                "end from PermissaoModel p where p.id = ?1" , Boolean.class)
                .setParameter(1, permissaoId.getId())
                .getSingleResult();
    }


}
