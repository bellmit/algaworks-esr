package com.algaworks.algafood.domain.model.cidade;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
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
            throw new CidadeEmUsoException(cidade.getNome());
        }

        this.cidadeRepository.adicionar(cidade);
    }

    @Override
    public void atualizar(Cidade cidade) {

        if(cidadeRepository.existeCidadeComNomeComIdDiferente(cidade.getNome(), cidade.getCidadeId())) {
            throw new CidadeEmUsoException(cidade.getNome());
        }

        this.cidadeRepository.atualizar(cidade);
    }

    @Override
    public void remover(CidadeId cidadeId) {
        cidadeRepository.remover(cidadeId);
    }

    @Override
    public Cidade buscar(CidadeId cidadeId) {
        return cidadeRepository.buscar(cidadeId)
                .orElseThrow(() -> new CidadeNaoEncontradaException(cidadeId.getId()));
    }
}
