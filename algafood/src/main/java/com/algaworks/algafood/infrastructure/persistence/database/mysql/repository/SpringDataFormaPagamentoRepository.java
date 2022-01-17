package com.algaworks.algafood.infrastructure.persistence.database.mysql.repository;

import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.FormaPagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringDataFormaPagamentoRepository extends JpaRepository<FormaPagamentoModel, UUID> {
    Optional<FormaPagamentoModel> findByDescricao(String descricao);
    boolean existsByDescricao(String descricao);
    boolean existsByDescricaoAndIdNot(String descricao, UUID id);
}
