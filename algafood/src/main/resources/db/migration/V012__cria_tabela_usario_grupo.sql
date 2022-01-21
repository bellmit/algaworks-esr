create table usuario_grupo
(
    usuario_id binary(16) not null,
    grupo_id   binary(16) not null,

    primary key (usuario_id, grupo_id)
) engine = InnoDB
  default charset = utf8;