package com.algaworks.algafood.domain.model.restaurante;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import com.algaworks.algafood.domain.model.cozinha.CozinhaId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurante {
    @EqualsAndHashCode.Include
    private RestauranteId restauranteId;
    private String nome;
    private BigDecimal taxaFrete;
    private CozinhaId cozinhaId;

    public Restaurante(RestauranteId restauranteId, String nome, BigDecimal taxaFrete, CozinhaId cozinhaId) {
        this.setRestauranteId(restauranteId);
        this.setNome(nome);
        this.setTaxaFrete(taxaFrete);
        this.setCozinhaId(cozinhaId);
    }

    private void setRestauranteId(RestauranteId restauranteId) {
        if(restauranteId == null) {
            throw new PropriedadeInvalidaException(Restaurante.class, "restauranteId", "deve ser informado");
        }

        this.restauranteId = restauranteId;
    }

    private void setNome(String nome) {
        if(!StringUtils.hasText(nome)) {
            throw new PropriedadeInvalidaException(Restaurante.class, "nome", "deve ser informado");
        }

        this.nome = nome;
    }

    private void setTaxaFrete(BigDecimal taxaFrete) {
        if(taxaFrete == null || taxaFrete.equals(BigDecimal.ZERO)) {
            throw new PropriedadeInvalidaException(Restaurante.class, "taxaFrete", "deve ser maior que zero");
        }

        this.taxaFrete = taxaFrete;
    }

    private void setCozinhaId(CozinhaId cozinhaId) {
        if(cozinhaId == null) {
            throw new PropriedadeInvalidaException(Restaurante.class, "cozinhaId", "deve ser informado");
        }

        this.cozinhaId = cozinhaId;
    }
}
