package com.algaworks.algafood.domain.model.cidade;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import com.algaworks.algafood.domain.model.estado.EstadoId;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Getter
@ToString
public class Cidade {
    private CidadeId cidadeId;
    private String nome;
    private EstadoId estadoId;

    public Cidade(CidadeId cidadeId, String nome, EstadoId estadoId) {
        this.setCidadeId(cidadeId);
        this.setNome(nome);
        this.setEstadoId(estadoId);
    }

    private void setCidadeId(CidadeId cidadeId) {
        if (cidadeId == null) {
            throw new PropriedadeInvalidaException(Cidade.class, "cidadeId", "deve ser informado");
        }

        this.cidadeId = cidadeId;
    }

    private void setNome(String nome) {
        if (!StringUtils.hasText(nome)) {
            throw new PropriedadeInvalidaException(Cidade.class, "nome", "deve ser informado");
        }
        this.nome = nome;
    }

    private void setEstadoId(EstadoId estadoId) {
        if (estadoId == null) {
            throw new PropriedadeInvalidaException(Cidade.class, "estadoId", "deve ser informado");
        }

        this.estadoId = estadoId;
    }
}
