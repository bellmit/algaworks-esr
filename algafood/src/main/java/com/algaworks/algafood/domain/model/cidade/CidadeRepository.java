package com.algaworks.algafood.domain.model.cidade;

import com.algaworks.algafood.domain.model.cidade.Cidade;
import com.algaworks.algafood.domain.model.estado.EstadoId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CidadeRepository {
    List<Cidade> listar();
    void adicionar(Cidade cidade);
    Optional<Cidade> buscar(CidadeId cidadeId);
    Optional<Cidade> buscarPeloNome(String nome);
    void atualizar(Cidade cidade);
    void remover(CidadeId cidadeId);
    boolean existeCidadeComNome(String nome);
    boolean existeCidadeComNomeComIdDiferente(String nome, CidadeId cidadeId);
    boolean existeCidadeComId(CidadeId cidadeId);
    boolean existeCidadeComEstadoId(EstadoId estadoId);
}
