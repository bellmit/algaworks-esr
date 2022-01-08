package com.algaworks.algafood.domain.model.cidade;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CidadeDomainService {

    private CidadeRepository cidadeRepository;

    public List<Cidade> listar() {
        return cidadeRepository.listar();
    }

    public void adicionar(Cidade cidade) {
        if(cidadeRepository.existeCidadeComNome(cidade.getNome())) {
            throw new EntidadeEmUsoException("Ja existe uma cidade cadastrada com o nome: " + cidade.getNome());
        }

        this.cidadeRepository.adicionar(cidade);
    }

    public void atualizar(Cidade cidade) {

        if(cidadeRepository.existeCidadeComNomeComIdDiferente(cidade.getNome(), cidade.getId())) {
            throw new EntidadeEmUsoException("Ja existe uma cidade cadastrada com o nome: " + cidade.getNome());
        }

        this.cidadeRepository.atualizar(cidade);
    }

    public Cidade buscar(String id) {
        return cidadeRepository.buscar(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Nao foi possivel encontrar uma cidade de id: " + id
                ));
    }

    public void remover(Cidade cidade) {
        cidadeRepository.remover(cidade);
    }
}
