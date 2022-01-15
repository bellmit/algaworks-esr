package com.algaworks.algafood.infrastructure.persistence.model.cozinha;

import com.algaworks.algafood.domain.model.cozinha.Cozinha;
import com.algaworks.algafood.domain.model.cozinha.CozinhaId;
import com.algaworks.algafood.domain.model.cozinha.CozinhaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MysqlCozinhaRepository implements CozinhaRepository {

    private CozinhaTranslator cozinhaTranslator;
    private SpringDataMysqlCozinhaRepository cozinhaRepository;

    @Override
    public List<Cozinha> listar() {
        return cozinhaRepository.findAll()
                .stream()
                .map(model -> cozinhaTranslator.toCozinhaFromCozinhaModel(model))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void adicionar(Cozinha cozinha) {
        cozinhaRepository.save(cozinhaTranslator.toCozinhaModelFromCozinha(cozinha));
    }

    @Override
    public Optional<Cozinha> buscar(CozinhaId cozinhaId) {
        return cozinhaRepository.findById(cozinhaId.getId())
                .stream()
                .map(model -> cozinhaTranslator.toCozinhaFromCozinhaModel(model))
                .findFirst();
    }

    @Override
    public Optional<Cozinha> buscarPeloNome(String nome) {
        return cozinhaRepository.findByNome(nome)
                .stream()
                .map(model -> cozinhaTranslator.toCozinhaFromCozinhaModel(model))
                .findFirst();
    }

    @Transactional
    @Override
    public void atualizar(Cozinha cozinha) {
        cozinhaRepository.save(cozinhaTranslator.toCozinhaModelFromCozinha(cozinha));
    }

    @Transactional
    @Override
    public void remover(CozinhaId cozinhaId) {
        cozinhaRepository.deleteById(cozinhaId.getId());
    }

    @Override
    public boolean existeCozinhaComId(CozinhaId cozinhaId) {
        return cozinhaRepository.existsById(cozinhaId.getId());
    }

    @Override
    public boolean existeCozinhaComNome(String nome) {
        return cozinhaRepository.existsByNome(nome);
    }

    @Override
    public boolean existeCozinhaComNomeComIdDiferente(String nome, CozinhaId cozinhaId) {
        return cozinhaRepository.existsByNomeAndAndIdNot(nome, cozinhaId.getId());
    }


}
