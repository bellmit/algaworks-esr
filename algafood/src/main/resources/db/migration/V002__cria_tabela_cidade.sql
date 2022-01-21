create table cidade
(
    id          binary(16)  not null,
    nome_cidade varchar(80) not null,
    nome_estado varchar(80) not null,
    primary key (id)
) engine = InnoDB
  default charset = utf8;
