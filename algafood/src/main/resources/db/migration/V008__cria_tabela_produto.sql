create table produto
(
    id             binary(16)     not null,
    restaurante_id binary(16)     not null,
    nome           varchar(80)    not null,
    descricao      text           not null,
    preco          decimal(10, 2) not null,
    ativo          tinyint(1)     not null,

    primary key (id)
) engine = InnoDB
  default charset = utf8;