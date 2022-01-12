package com.algaworks.algafood.domain.model.permissao;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class DomainPermissaoService implements PermissaoService {
    private PermissaoRepository permissaoRepository;

    @Override
    public List<Permissao> listar() {
        return permissaoRepository.listar();
    }

    @Override
    public void adicionar(Permissao permissao) {
        if(permissaoRepository.existePermissaoComNome(permissao.getNome())) {
            throw new PermissaoEmUsoException(permissao.getNome());
        }

        this.permissaoRepository.adicionar(permissao);

    }

    @Override
    public Permissao buscar(PermissaoId permissaoId) {
        return this.permissaoRepository.buscar(permissaoId)
                .orElseThrow(() -> new PermissaoNaoEncontradaException(permissaoId.getId()));
    }

    @Override
    public void atualizar(Permissao permissao) {
        if(!this.permissaoRepository.existePermissaoComId(permissao.getPermissaoId())) {
            throw new PermissaoNaoEncontradaException(permissao.getPermissaoId().getId());
        }


        if (this.permissaoRepository.existePermissaoComNomeComIdDiferente(
                permissao.getNome(),
                permissao.getPermissaoId())
        ) {
            throw new PermissaoEmUsoException(permissao.getNome());
        }

        this.permissaoRepository.atualizar(permissao);
    }

    @Override
    public void remover(PermissaoId permissaoId) {
        permissaoRepository.remover(permissaoId);
    }
}
