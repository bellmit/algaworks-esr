package com.algaworks.algafood.infrastructure.persistence.database.mysql.repository;

import com.algaworks.algafood.domain.model.cidade.Cidade;
import com.algaworks.algafood.domain.model.cidade.CidadeId;
import com.algaworks.algafood.domain.model.cidade.CidadeRepository;
import com.algaworks.algafood.domain.model.estado.EstadoId;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.service.CidadeTranslator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MysqlCidadeRepository implements CidadeRepository {

    private EntityManager manager;
    private CidadeTranslator cidadeTranslator;
    private SpringDataCidadeRepository cidadeRepository;


    @Override
    public List<Cidade> listar() {
        return cidadeRepository.findAll()
                .stream()
                .map(model -> cidadeTranslator.toCidadeFromCidadeModel(model))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void adicionar(Cidade cidade) {
        cidadeRepository.save(cidadeTranslator.toCidadeModelFromCidade(cidade));
    }

    @Override
    public Optional<Cidade> buscar(CidadeId cidadeId) {
        return cidadeRepository.findById(cidadeId.getId())
                .stream()
                .map(model -> cidadeTranslator.toCidadeFromCidadeModel(model))
                .findFirst();

    }

    @Override
    public Optional<Cidade> buscarPeloNome(String nome) {
        return cidadeRepository.findByNome(nome)
                .stream()
                .map(model -> cidadeTranslator.toCidadeFromCidadeModel(model))
                .findFirst();
    }

    @Transactional
    @Override
    public void atualizar(Cidade cidade) {
        cidadeRepository.save(cidadeTranslator.toCidadeModelFromCidade(cidade));
    }

    @Transactional
    @Override
    public void remover(CidadeId cidadeId) {
        cidadeRepository.deleteById(cidadeId.getId());
    }

    @Override
    public boolean existeCidadeComNome(String nome) {
        return cidadeRepository.existsByNome(nome);
    }

    @Override
    public boolean existeCidadeComNomeComIdDiferente(String nome, CidadeId cidadeId) {
        return cidadeRepository.existsByNomeAndIdNot(nome, cidadeId.getId());
    }

    @Override
    public boolean existeCidadeComId(CidadeId cidadeId) {
        return cidadeRepository.existsById(cidadeId.getId());
    }

    @Override
    public boolean existeCidadeComEstadoId(EstadoId estadoId) {
        return cidadeRepository.existsByEstadoId(estadoId.getId());
    }


}
