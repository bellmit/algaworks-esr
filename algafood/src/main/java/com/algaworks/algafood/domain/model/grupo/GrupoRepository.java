package com.algaworks.algafood.domain.model.grupo;

import java.util.List;
import java.util.Optional;

public interface GrupoRepository {
    List<Grupo> listar();
    void adicionar(Grupo grupo);
    void atualizar(Grupo grupo);
    void remover(GrupoId grupoId);
    Optional<Grupo> buscar(GrupoId grupoId);
    boolean existeGrupoComId(GrupoId grupoId);
}
