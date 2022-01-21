create table grupo
(
    id   BINARY(16) not null,
    nome varchar(60),
    primary key (id)
) engine = InnoDB
  default charset = utf8;