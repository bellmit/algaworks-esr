package com.algaworks.algafood.domain.model.cozinha;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Getter
@ToString
public class Cozinha {
    private CozinhaId cozinhaId;
    private String nome;

    public Cozinha(CozinhaId cozinhaId, String nome) {
        this.setCozinhaId(cozinhaId);
        this.setNome(nome);
    }

    private void setCozinhaId(CozinhaId cozinhaId) {
        if(cozinhaId == null) {
            throw new PropriedadeInvalidaException(Cozinha.class, "cozinhaId", "deve ser informado");
        }
        this.cozinhaId = cozinhaId;
    }

    private void setNome(String nome) {
        if (!StringUtils.hasText(nome)) {
            throw new PropriedadeInvalidaException(Cozinha.class, "nome", "deve ser informado");
        }
        this.nome = nome;
    }
}
