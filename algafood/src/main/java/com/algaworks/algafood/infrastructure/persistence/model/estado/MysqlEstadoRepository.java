package com.algaworks.algafood.infrastructure.persistence.model.estado;

import com.algaworks.algafood.domain.model.estado.Estado;
import com.algaworks.algafood.domain.model.estado.EstadoId;
import com.algaworks.algafood.domain.model.estado.EstadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MysqlEstadoRepository implements EstadoRepository {

    private EstadoTranslator estadoTranslator;
    private SpringDataEstadoRepository estadoRepository;

    @Override
    public List<Estado> listar() {
        return estadoRepository.findAll()
                .stream()
                .map(model -> estadoTranslator.toEstadoFromEstadoModel(model))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void adicionar(Estado estado) {
        estadoRepository.save(estadoTranslator.toEstadoModelFromEstado(estado));
    }

    @Override
    public Optional<Estado> buscar(EstadoId estadoId) {
        return estadoRepository.findById(estadoId.getId())
                .stream()
                .map(model -> estadoTranslator.toEstadoFromEstadoModel(model))
                .findFirst();

    }

    @Override
    public Optional<Estado> buscarPeloNome(String nome) {
        return estadoRepository.findByNome(nome)
                .stream()
                .map(model -> estadoTranslator.toEstadoFromEstadoModel(model))
                .findFirst();
    }

    @Transactional
    @Override
    public void atualizar(Estado estado) {
        estadoRepository.save(estadoTranslator.toEstadoModelFromEstado(estado));
    }

    @Transactional
    @Override
    public void remover(EstadoId estadoId) {
        estadoRepository.deleteById(estadoId.getId());
    }

    @Override
    public boolean existeEstadoComNome(String nome) {
        return estadoRepository.existsByNome(nome);
    }

    @Override
    public boolean existeEstadoComNomeComIdDiferente(String nome, EstadoId estadoId) {
        return estadoRepository.existsByNomeAndIdNot(nome, estadoId.getId());
    }

    @Override
    public boolean existeEstadoComId(EstadoId estadoId) {
        return estadoRepository.existsById(estadoId.getId());
    }


}
