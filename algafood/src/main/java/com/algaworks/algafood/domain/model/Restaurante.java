package com.algaworks.algafood.domain.model;

import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.Cozinha;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class Restaurante {
    private UUID id;
    private String nome;
    private BigDecimal taxaFrete;
    private Cozinha cozinha;

    public Restaurante(UUID id, String nome, BigDecimal taxaFrete, Cozinha cozinha) {

        if(id == null) {
            throw new NegocioException("id do restaurante nao pode ser null ou vazio");
        }

        if(taxaFrete == null || taxaFrete.equals(BigDecimal.ZERO)) {
            throw new NegocioException("Taxa frete nao pode ser null ou zero");
        }

        if(!StringUtils.hasText(nome)) {
            throw new NegocioException("Nome do restaurante nao pode ser null ou vazio");
        }

        if(cozinha == null) {
            throw new NegocioException("cozinha do restaurante nao pode der null");
        }

        this.id = id;
        this.nome = nome;
        this.cozinha = cozinha;
    }
}
