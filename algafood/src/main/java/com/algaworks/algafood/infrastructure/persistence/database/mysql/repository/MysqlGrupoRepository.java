package com.algaworks.algafood.infrastructure.persistence.database.mysql.repository;

import com.algaworks.algafood.domain.model.grupo.Grupo;
import com.algaworks.algafood.domain.model.grupo.GrupoId;
import com.algaworks.algafood.domain.model.grupo.GrupoRepository;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.GrupoModel;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.service.GrupoTranslator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class MysqlGrupoRepository implements GrupoRepository {

    private SpringDataGrupoRepository grupoRepository;
    private GrupoTranslator grupoTranslator;

    @Override
    public List<Grupo> listar() {
        return grupoRepository.findAll()
                .stream()
                .map(this.grupoTranslator::toGrupo)
                .collect(Collectors.toList());
    }

    @Override
    public void adicionar(Grupo grupo) {
        GrupoModel grupoModel = grupoTranslator.toGrupoModel(grupo);
        grupoRepository.save(grupoModel);
    }

    @Override
    public void atualizar(Grupo grupo) {
        GrupoModel grupoModel = grupoTranslator.toGrupoModel(grupo);
        grupoRepository.save(grupoModel);
    }

    @Override
    public void remover(GrupoId grupoId) {
        grupoRepository.deleteById(grupoId.getId());
    }

    @Override
    public Optional<Grupo> buscar(GrupoId grupoId) {
        return grupoRepository.findById(grupoId.getId())
                .map(this.grupoTranslator::toGrupo)
                .stream()
                .findFirst();
    }

    @Override
    public boolean existeGrupoComId(GrupoId grupoId) {
        return grupoRepository.existsById(grupoId.getId());
    }
}
