package com.algaworks.algafood.domain.model.permissao;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PermissaoDomainService {
    private PermissaoRepository permissaoRepository;

    public List<Permissao> listar() {
        return permissaoRepository.listar();
    }

    public void adicionar(Permissao permissao) {
        if(permissaoRepository.existePermissaoComNome(permissao.getNome())) {
            throw new EntidadeEmUsoException(
                    "Ja existe uma permissao cadastrada com o nome: " + permissao.getNome());
        }

        this.permissaoRepository.adicionar(permissao);

    }

    public Permissao buscar(String id) {
        return this.permissaoRepository.buscar(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Nao foi possivel encontrar uma permissao de id: " + id
                ));
    }

    public void atualizar(Permissao permissao) {
        if (this.permissaoRepository.existePermissaoComNomeComIdDiferente(
                permissao.getNome(), permissao.getId())
        ) {
            throw new EntidadeEmUsoException(
                    "Ja existe uma permissao cadastrada com o nome: " + permissao.getNome()
            );
        }

        this.permissaoRepository.atualizar(permissao);
    }

    public void remover(Permissao permissao) {
        permissaoRepository.remover(permissao);
    }
}
