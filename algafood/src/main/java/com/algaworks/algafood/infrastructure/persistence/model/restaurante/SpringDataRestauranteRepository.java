package com.algaworks.algafood.infrastructure.persistence.model.restaurante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringDataRestauranteRepository extends JpaRepository<RestauranteModel, UUID> {
    Optional<RestauranteModel> findByNome(String nome);
    boolean existsByNome(String nome);
    boolean existsByNomeAndIdNot(String nome, UUID id);
    boolean existsByCozinha_Id(UUID id);
}
