package com.algaworks.algafood.domain.model.grupo;

import java.util.List;

public interface GrupoService {
    List<Grupo> listar();
    void adicionar(Grupo grupo);
    void atualizar(Grupo grupo);
    void remover(GrupoId grupoId);
    Grupo buscar(GrupoId grupoId);
}
