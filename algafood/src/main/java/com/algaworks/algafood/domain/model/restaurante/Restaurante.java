package com.algaworks.algafood.domain.model.restaurante;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import com.algaworks.algafood.domain.model.cozinha.CozinhaId;
import com.algaworks.algafood.domain.model.formapagamento.FormaPagamento;
import com.algaworks.algafood.domain.model.formapagamento.FormaPagamentoId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurante {
    @EqualsAndHashCode.Include
    private RestauranteId restauranteId;
    private String nome;
    private BigDecimal taxaFrete;
    private CozinhaId cozinhaId;
    private Set<FormaPagamentoId> formaPagamentos;

    public Restaurante(RestauranteId restauranteId, String nome, BigDecimal taxaFrete, CozinhaId cozinhaId) {
        this();
        this.setRestauranteId(restauranteId);
        this.setNome(nome);
        this.setTaxaFrete(taxaFrete);
        this.setCozinhaId(cozinhaId);
    }

    private Restaurante() {
        this.formaPagamentos = new HashSet<>();
    }

    public void adicionarFormaPagamento(FormaPagamentoId formaPagamentoId) {
        if(formaPagamentoId == null) {
            throw new PropriedadeInvalidaException(Restaurante.class, "formaPagamentos", "deve ser informado");
        }

        this.formaPagamentos.add(formaPagamentoId);
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
