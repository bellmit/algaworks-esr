package com.algaworks.algafood.infrastructure.persistence.model.cozinha;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringDataMysqlCozinhaRepository extends JpaRepository<CozinhaModel, UUID> {
    Optional<CozinhaModel> findByNome(String nome);
    boolean existsByNome(String nome);
    boolean existsByNomeAndAndIdNot(String nome, UUID id);
}
