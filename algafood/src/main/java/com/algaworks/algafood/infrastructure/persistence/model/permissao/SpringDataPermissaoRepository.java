package com.algaworks.algafood.infrastructure.persistence.model.permissao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringDataPermissaoRepository extends JpaRepository<PermissaoModel, UUID> {
    Optional<PermissaoModel> findByNome(String nome);
    boolean existsByNome(String nome);
    boolean existsByNomeAndIdNot(String nome, UUID id);
}
