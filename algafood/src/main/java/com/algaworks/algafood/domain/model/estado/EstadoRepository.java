package com.algaworks.algafood.domain.model.estado;

import java.util.List;
import java.util.Optional;

public interface EstadoRepository {
    List<Estado> listar();
    void adicionar(Estado cidade);
    Optional<Estado> buscar(String id);
    Optional<Estado> buscarPeloNome(String nome);
    void atualizar(Estado estado);
    void remover(Estado estado);
    boolean existeEstadoComNome(String nome);
    boolean existeEstadoComNomeComIdDiferente(String nome, String id);
}
