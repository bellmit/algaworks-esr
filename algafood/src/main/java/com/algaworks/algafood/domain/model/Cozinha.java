package com.algaworks.algafood.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Cozinha {
    @Id
    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
}


