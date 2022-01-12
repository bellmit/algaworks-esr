package com.algaworks.algafood.domain.model.cidade;

import java.util.List;

public interface CidadeService {
    List<Cidade> listar();
    void adicionar(Cidade cidade);
    void atualizar(Cidade cidade);
    void remover(CidadeId cidadeId);
    Cidade buscar(CidadeId cidadeId);
}
