package com.algaworks.algafood.domain.model.estado;

import java.util.List;

public interface EstadoService {
    List<Estado> listar();
    void adicionar(Estado estado);
    Estado buscar(EstadoId estadoId);
    void atualizar(Estado estado);
    void remover(EstadoId estadoId);
}
