package com.algaworks.algafood.domain.service.impl;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.service.EstadoService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

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
            throw new EntidadeEmUsoException("Ja existe um estado cadastrado com o nome: " + estado.getNome());
        }

        this.estadoRepository.adicionar(estado);
    }

    @Override
    public void atualizar(Estado estado) {

        if(estadoRepository.existeEstadoComNomeComIdDiferente(estado.getNome(), estado.getId())) {
            throw new EntidadeEmUsoException("Ja existe um estado cadastrado com o nome: " + estado.getNome());
        }

        this.estadoRepository.atualizar(estado);
    }

    @Override
    public Estado buscar(UUID id) {
        return estadoRepository.buscar(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Nao foi possivel encontrar um estado de id: " + id
                ));
    }

    @Override
    public void remover(Estado estado) {
        estadoRepository.remover(estado);
    }
}
