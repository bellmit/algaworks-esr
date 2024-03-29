package com.algaworks.algafood.infrastructure.persistence.database.mysql.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cidade")
public class CidadeModel {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @JoinColumn(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false)
    private EstadoModel estado;
}


