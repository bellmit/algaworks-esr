package com.algaworks.algafood.domain.model.restaurante;

import lombok.Getter;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

@Getter
public class Restaurante {
    private String id;
    private String nome;
    private BigDecimal taxaFrete;

    public Restaurante(String id, String nome) {

        if(!StringUtils.hasText(id)) {
            throw new RestauranteException("id do restaurante nao pode ser null ou vazio");
        }

        if(!StringUtils.hasText(nome)) {
            throw new RestauranteException("Nome do restaurante nao pode ser null ou vazio");
        }

        this.nome = nome;
    }

    public void atualizarFrete(BigDecimal frete) {
        if(frete == null) {
            throw new RestauranteException("frete do restaurante nao pode ser null");
        }
        this.taxaFrete = frete;
    }
}
