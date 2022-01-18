package com.algaworks.algafood.infrastructure.persistence.database.mysql.model;

import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.CozinhaModel;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.EnderecoModel;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.FormaPagamentoModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "Restaurante")
public class RestauranteModel {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String nome;

    @Column(name = "taxa_frete")
    private BigDecimal taxaFrete;

    @ManyToOne
    @JoinColumn(name = "cozinha_id", nullable = false)
    private CozinhaModel cozinha;

    @Embedded
    private EnderecoModel endereco;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataAtualizacao;

    @ManyToMany
    @JoinTable(name = "restaurante_forma_pagamento",
            joinColumns = @JoinColumn(name = "restaurante_id"),
            inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
    private Set<FormaPagamentoModel> formaPagamentos = new HashSet<>();
}
