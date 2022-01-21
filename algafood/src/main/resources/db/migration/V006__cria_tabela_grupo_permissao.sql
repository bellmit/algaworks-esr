create table grupo_permissao
(
    grupo_id     BINARY(16) not null,
    permissao_id BINARY(16) not null,
    primary key (grupo_id, permissao_id)
) engine = InnoDB
  default charset = utf8;