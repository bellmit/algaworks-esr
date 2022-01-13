package com.algaworks.algafood.domain.model.cidade;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import com.algaworks.algafood.domain.model.estado.EstadoRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DomainCidadeService implements CidadeService {

    private CidadeRepository cidadeRepository;
    private EstadoRepository estadoRepository;

    @Override
    public List<Cidade> listar() {
        return cidadeRepository.listar();
    }

    @Override
    public void adicionar(Cidade cidade) {
        if(cidadeRepository.existeCidadeComNome(cidade.getNome())) {
            throw new CidadeEmUsoException(cidade.getNome());
        }

        if(!estadoRepository.existeEstadoComId(cidade.getEstadoId())) {
            throw new PropriedadeInvalidaException(Cidade.class, "estadoId", "nao foi possivel encontrar um estado.");
        }

        this.cidadeRepository.adicionar(cidade);
    }

    @Override
    public void atualizar(Cidade cidade) {
        if(!cidadeRepository.existeCidadeComId(cidade.getCidadeId())) {
            throw new CidadeNaoEncontradaException(cidade.getCidadeId().getId());
        }

        if(cidadeRepository.existeCidadeComNomeComIdDiferente(cidade.getNome(), cidade.getCidadeId())) {
            throw new CidadeEmUsoException(cidade.getNome());
        }

        this.cidadeRepository.atualizar(cidade);
    }

    @Override
    public void remover(CidadeId cidadeId) {
        if(!cidadeRepository.existeCidadeComId(cidadeId)) {
            throw new CidadeNaoEncontradaException(cidadeId.getId());
        }

        cidadeRepository.remover(cidadeId);
    }

    @Override
    public Cidade buscar(CidadeId cidadeId) {
        return cidadeRepository.buscar(cidadeId)
                .orElseThrow(() -> new CidadeNaoEncontradaException(cidadeId.getId()));
    }
}
