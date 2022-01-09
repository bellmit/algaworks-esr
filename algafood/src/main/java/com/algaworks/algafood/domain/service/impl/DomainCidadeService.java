package com.algaworks.algafood.domain.service.impl;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.service.CidadeService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class DomainCidadeService implements CidadeService {

    private CidadeRepository cidadeRepository;

    @Override
    public List<Cidade> listar() {
        return cidadeRepository.listar();
    }

    @Override
    public void adicionar(Cidade cidade) {
        if(cidadeRepository.existeCidadeComNome(cidade.getNome())) {
            throw new EntidadeEmUsoException("Ja existe uma cidade cadastrada com o nome: " + cidade.getNome());
        }

        this.cidadeRepository.adicionar(cidade);
    }

    @Override
    public void atualizar(Cidade cidade) {

        if(cidadeRepository.existeCidadeComNomeComIdDiferente(cidade.getNome(), cidade.getId())) {
            throw new EntidadeEmUsoException("Ja existe uma cidade cadastrada com o nome: " + cidade.getNome());
        }

        this.cidadeRepository.atualizar(cidade);
    }

    @Override
    public void remover(Cidade cidade) {
        cidadeRepository.remover(cidade);
    }

    @Override
    public Cidade buscar(UUID id) {
        return cidadeRepository.buscar(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Nao foi possivel encontrar uma cidade de id: " + id
                ));
    }
}
