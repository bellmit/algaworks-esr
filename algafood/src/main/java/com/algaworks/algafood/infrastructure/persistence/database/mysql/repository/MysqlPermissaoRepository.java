package com.algaworks.algafood.infrastructure.persistence.database.mysql.repository;

import com.algaworks.algafood.domain.model.permissao.Permissao;
import com.algaworks.algafood.domain.model.permissao.PermissaoId;
import com.algaworks.algafood.domain.model.permissao.PermissaoRepository;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.service.PermissaoTranslator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MysqlPermissaoRepository implements PermissaoRepository {

    private PermissaoTranslator permissaoTranslator;
    private SpringDataPermissaoRepository permissaoRepository;

    @Override
    public List<Permissao> listar() {
        return permissaoRepository.findAll()
                .stream()
                .map(model -> permissaoTranslator.toPermissaoFromPermissaoModel(model))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void adicionar(Permissao permissao) {
        permissaoRepository.save(permissaoTranslator.toPermissaoModelFromPermissao(permissao));
    }

    @Override
    public Optional<Permissao> buscar(PermissaoId permissaoId) {
        return permissaoRepository.findById(permissaoId.getId())
                .stream()
                .map(model -> permissaoTranslator.toPermissaoFromPermissaoModel(model))
                .findFirst();

    }

    @Override
    public Optional<Permissao> buscarPeloNome(String nome) {
        return permissaoRepository.findByNome(nome)
                .stream()
                .map(model -> permissaoTranslator.toPermissaoFromPermissaoModel(model))
                .findFirst();
    }

    @Transactional
    @Override
    public void atualizar(Permissao permissao) {
        permissaoRepository.save(permissaoTranslator.toPermissaoModelFromPermissao(permissao));
    }

    @Transactional
    @Override
    public void remover(PermissaoId permissaoId) {
        permissaoRepository.deleteById(permissaoId.getId());
    }

    @Override
    public boolean existePermissaoComNome(String nome) {
        return permissaoRepository.existsByNome(nome);
    }

    @Override
    public boolean existePermissaoComNomeComIdDiferente(String nome, PermissaoId permissaoId) {
        return permissaoRepository.existsByNomeAndIdNot(nome, permissaoId.getId());
    }

    @Override
    public boolean existePermissaoComId(PermissaoId permissaoId) {
        return permissaoRepository.existsById(permissaoId.getId());
    }


}
