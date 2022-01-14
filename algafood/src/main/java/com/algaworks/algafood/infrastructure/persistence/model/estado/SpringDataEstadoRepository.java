package com.algaworks.algafood.infrastructure.persistence.model.estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringDataEstadoRepository extends JpaRepository<EstadoModel, UUID> {
    Optional<EstadoModel> findByNome(String nome);
    boolean existsByNome(String nome);
    boolean existsByNomeAndIdNot(String nome, UUID id);
}
