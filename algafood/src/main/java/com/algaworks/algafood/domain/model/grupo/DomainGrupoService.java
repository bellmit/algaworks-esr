package com.algaworks.algafood.domain.model.grupo;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DomainGrupoService implements GrupoService {

    private GrupoRepository grupoRepository;

    @Override
    public List<Grupo> listar() {
        return grupoRepository.listar();
    }

    @Override
    public void adicionar(Grupo grupo) {
        grupoRepository.adicionar(grupo);
    }

    @Override
    public void atualizar(Grupo grupo) {
        if (grupoRepository.existeGrupoComId(grupo.getGrupoId())) {
            throw new GrupoNaoEncontradoException(grupo.getGrupoId().getId());
        }
        grupoRepository.atualizar(grupo);
    }

    @Override
    public void remover(GrupoId grupoId) {
        if (grupoRepository.existeGrupoComId(grupoId)) {
            throw new GrupoNaoEncontradoException(grupoId.getId());
        }
        grupoRepository.remover(grupoId);
    }

    @Override
    public Grupo buscar(GrupoId grupoId) {
        return grupoRepository.buscar(grupoId)
                .orElseThrow(() -> new GrupoNaoEncontradoException(grupoId.getId()));
    }
}
