package com.algaworks.algafood.domain.model.restaurante;

import com.algaworks.algafood.domain.model.cozinha.Cozinha;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

@Getter
public class Restaurante {
    private String id;
    private String nome;
    private BigDecimal taxaFrete;
    private Cozinha cozinha;

    public Restaurante(String id, String nome, Cozinha cozinha) {

        if(!StringUtils.hasText(id)) {
            throw new RestauranteException("id do restaurante nao pode ser null ou vazio");
        }

        if(!StringUtils.hasText(nome)) {
            throw new RestauranteException("Nome do restaurante nao pode ser null ou vazio");
        }

        if(cozinha == null) {
            throw new RestauranteException("cozinha do restaurante nao pode der null");
        }

        this.id = id;
        this.nome = nome;
        this.cozinha = cozinha;
    }

    public void atualizarFrete(BigDecimal frete) {
        if(frete == null) {
            throw new RestauranteException("frete do restaurante nao pode ser null");
        }
        this.taxaFrete = frete;
    }
}
