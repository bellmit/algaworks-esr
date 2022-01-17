package com.algaworks.algafood.infrastructure.persistence.database.mysql.repository;

import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.CidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringDataCidadeRepository extends JpaRepository<CidadeModel, UUID> {
    Optional<CidadeModel> findByNome(String nome);
    boolean existsByNome(String nome);
    boolean existsByNomeAndIdNot(String nome, UUID id);
    boolean existsByEstadoId(UUID id);
}
