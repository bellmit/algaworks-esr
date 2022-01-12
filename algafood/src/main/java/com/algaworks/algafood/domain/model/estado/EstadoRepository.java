package com.algaworks.algafood.domain.model.estado;

import com.algaworks.algafood.domain.model.estado.Estado;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EstadoRepository {
    List<Estado> listar();
    void adicionar(Estado cidade);
    Optional<Estado> buscar(EstadoId estadoId);
    Optional<Estado> buscarPeloNome(String nome);
    void atualizar(Estado estado);
    void remover(EstadoId estadoId);
    boolean existeEstadoComNome(String nome);
    boolean existeEstadoComNomeComIdDiferente(String nome, EstadoId estadoId);
    boolean existeEstadoComId(EstadoId estadoId);
}
