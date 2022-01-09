package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Estado;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EstadoRepository {
    List<Estado> listar();
    void adicionar(Estado cidade);
    Optional<Estado> buscar(UUID id);
    Optional<Estado> buscarPeloNome(String nome);
    void atualizar(Estado estado);
    void remover(Estado estado);
    boolean existeEstadoComNome(String nome);
    boolean existeEstadoComNomeComIdDiferente(String nome, UUID id);
}
