package com.algaworks.algafood.domain.model.usuario;

import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import com.algaworks.algafood.domain.model.grupo.GrupoId;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
public class Usuario {

    private UsuarioId usuarioId;
    private String nome;
    private String email;
    private String senha;
    private LocalDateTime dataCadastro;
    private Set<GrupoId> grupos;

    public Usuario(UsuarioId usuarioId, String nome, String email, String senha) {
        this();
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(UsuarioId usuarioId, String nome, String email, String senha, LocalDateTime dataCadastro) {
        this(usuarioId, nome, email, senha);
        this.setDataCadastro(dataCadastro);
    }

    private Usuario() {
        this.dataCadastro = LocalDateTime.now();
        this.grupos = new HashSet<>();
    }

    public void adicionarGrupo(GrupoId grupoId) {
        if (grupoId != null) {
           this.grupos.add(grupoId);
        }
    }

    private void setUsuarioId(UsuarioId usuarioId) {
        if(usuarioId == null) {
            throw new PropriedadeInvalidaException(Usuario.class, "usuarioId", "deve ser informado");
        }

        this.usuarioId = usuarioId;
    }

    private void setNome(String nome) {
        if(!StringUtils.hasText(nome)) {
            throw new PropriedadeInvalidaException(Usuario.class, "nome", "deve ser informado");
        }
        this.nome = nome;
    }

    private void setEmail(String email) {
        if(!StringUtils.hasText(email)) {
            throw new PropriedadeInvalidaException(Usuario.class, "email", "deve ser informado");
        }
        this.email = email;
    }

    private void setSenha(String senha) {
        if(!StringUtils.hasText(senha)) {
            throw new PropriedadeInvalidaException(Usuario.class, "senha", "deve ser informado");
        }
        this.senha = senha;
    }

    private void setDataCadastro(LocalDateTime dataCadastro) {
        if(dataCadastro == null) {
            throw new PropriedadeInvalidaException(Usuario.class, "dataCadastro", "deve ser informado");
        }
        this.dataCadastro = dataCadastro;
    }
}
