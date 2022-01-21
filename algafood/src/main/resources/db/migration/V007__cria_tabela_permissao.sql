create table permissao
(
    id        BINARY(16) not null,
    descricao varchar(60),
    nome      varchar(100),
    primary key (id)
) engine = InnoDB
  charset = utf8;