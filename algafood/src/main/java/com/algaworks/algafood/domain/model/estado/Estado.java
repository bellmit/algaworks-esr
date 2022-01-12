package com.algaworks.algafood.domain.model.estado;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Getter
@ToString
public class Estado {
    private EstadoId estadoId;
    private String nome;

    public Estado(EstadoId estadoId, String nome) {
       this.setEstadoId(estadoId);
       this.setNome(nome);
    }

    public void setEstadoId(EstadoId estadoId) {
        if(estadoId == null) {
            throw new PropriedadeInvalidaException(Estado.class, "estadoId", "deve ser informado");
        }

        this.estadoId = estadoId;
    }

    public void setNome(String nome) {
        if(!StringUtils.hasText(nome)) {
            throw new PropriedadeInvalidaException(Estado.class, "nome", "deve ser informado");
        }

        this.nome = nome;
    }
}
