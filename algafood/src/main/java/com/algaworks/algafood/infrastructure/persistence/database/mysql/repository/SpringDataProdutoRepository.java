package com.algaworks.algafood.infrastructure.persistence.database.mysql.repository;

import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataProdutoRepository extends JpaRepository<ProdutoModel, UUID> {
}
