alter table usuario_grupo
    add constraint fk_usuario_grupo_grupo
        foreign key (grupo_id) references grupo (id);

alter table usuario_grupo
    add constraint fk_usuario_grupo_usuario
        foreign key (usuario_id) references usuario (id);