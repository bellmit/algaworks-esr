package com.algaworks.algafood.domain.model.estado;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class EstadoDomainService {

    private EstadoRepository estadoRepository;

    public List<Estado> listar() {
        return estadoRepository.listar();
    }

    public void adicionar(Estado estado) {
        if(estadoRepository.existeEstadoComNome(estado.getNome())) {
            throw new EntidadeEmUsoException("Ja existe um estado cadastrado com o nome: " + estado.getNome());
        }

        this.estadoRepository.adicionar(estado);
    }

    public void atualizar(Estado estado) {

        if(estadoRepository.existeEstadoComNomeComIdDiferente(estado.getNome(), estado.getId())) {
            throw new EntidadeEmUsoException("Ja existe um estado cadastrado com o nome: " + estado.getNome());
        }

        this.estadoRepository.atualizar(estado);
    }

    public Estado buscar(String id) {
        return estadoRepository.buscar(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Nao foi possivel encontrar um estado de id: " + id
                ));
    }

    public void remover(Estado estado) {
        estadoRepository.remover(estado);
    }
}
