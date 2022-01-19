package com.algaworks.algafood.infrastructure.persistence.database.mysql.repository;

import com.algaworks.algafood.domain.model.usuario.Usuario;
import com.algaworks.algafood.domain.model.usuario.UsuarioId;
import com.algaworks.algafood.domain.model.usuario.UsuarioRepository;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.UsuarioModel;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.service.UsuarioTranslator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class MysqlUsuarioRepository implements UsuarioRepository {

    private SpringDataUsuarioRepository usuarioRepository;
    private UsuarioTranslator usuarioTranslator;

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll()
                .stream()
                .map(this.usuarioTranslator::toUsuario)
                .collect(Collectors.toList());
    }

    @Override
    public void adicionar(Usuario usuario) {
        UsuarioModel usuarioModel = usuarioTranslator.toUsuarioModel(usuario);
        usuarioRepository.save(usuarioModel);
    }

    @Override
    public void atualizar(Usuario usuario) {
        UsuarioModel usuarioModel = usuarioTranslator.toUsuarioModel(usuario);
        usuarioRepository.save(usuarioModel);
    }

    @Override
    public void remover(UsuarioId usuarioId) {
        usuarioRepository.deleteById(usuarioId.getId());
    }

    @Override
    public Optional<Usuario> buscar(UsuarioId usuarioId) {
        return usuarioRepository.findById(usuarioId.getId())
                .map(this.usuarioTranslator::toUsuario)
                .stream()
                .findFirst();
    }

    @Override
    public boolean existeUsuarioComId(UsuarioId usuarioId) {
        return usuarioRepository.existsById(usuarioId.getId());
    }
}
