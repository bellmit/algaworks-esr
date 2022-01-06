package com.algaworks.algafood.domain.model.restaurante;

import lombok.Getter;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

@Getter
public class Restaurante {
    private String nome;
    private BigDecimal taxaFrete;

    public Restaurante(String nome) {
        if(!StringUtils.hasText(nome)) {
            throw new RestauranteException("Nome do restaurante nao pode ser null ou vazio");
        }

        this.nome = nome;
    }
}
