create table usuario
(
    id            binary(16)   not null,
    nome          varchar(80)  not null,
    email         varchar(255) not null,
    senha         varchar(255) not null,
    data_cadastro datetime     not null,

    primary key (id)
) engine = InnoDB
  default charset = utf8;