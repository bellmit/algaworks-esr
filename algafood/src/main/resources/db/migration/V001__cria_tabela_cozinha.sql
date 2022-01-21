create table cozinha
(
    id   binary(16)  not null,
    nome varchar(60) not null,
    primary key (id)
) engine = InnoDB
  default charset = utf8;