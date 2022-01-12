package com.algaworks.algafood.domain.model.estado;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DomainEstadoService implements EstadoService {

    private EstadoRepository estadoRepository;

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
        estadoRepository.remover(estadoId);
    }
}
