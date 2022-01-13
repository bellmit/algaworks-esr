package com.algaworks.algafood.domain.model.estado;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import com.algaworks.algafood.domain.model.cidade.CidadeRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DomainEstadoService implements EstadoService {

    private EstadoRepository estadoRepository;
    private CidadeRepository cidadeRepository;

    @Override
    public List<Estado> listar() {
        return estadoRepository.listar();
    }

    @Override
    public void adicionar(Estado estado) {
        if(estadoRepository.existeEstadoComNome(estado.getNome())) {
            throw new EstadoEmUsoException(estado.getNome());
        }

        this.estadoRepository.adicionar(estado);
    }

    @Override
    public void atualizar(Estado estado) {

        if(!estadoRepository.existeEstadoComId(estado.getEstadoId())) {
            throw new EstadoNaoEncontradoException(estado.getEstadoId().getId());
        }

        if(estadoRepository.existeEstadoComNomeComIdDiferente(estado.getNome(), estado.getEstadoId())) {
            throw new EstadoEmUsoException(estado.getNome());
        }

        this.estadoRepository.atualizar(estado);
    }

    @Override
    public Estado buscar(EstadoId estadoId) {
        return estadoRepository.buscar(estadoId)
                .orElseThrow(() -> new EstadoNaoEncontradoException(estadoId.getId()));
    }

    @Override
    public void remover(EstadoId estadoId) {
        if(!estadoRepository.existeEstadoComId(estadoId)) {
            throw new EstadoNaoEncontradoException(estadoId.getId());
        }

        if(cidadeRepository.existeCidadeComEstadoId(estadoId)) {
            throw new EstadoEmUsoException();
        }

        estadoRepository.remover(estadoId);
    }
}
