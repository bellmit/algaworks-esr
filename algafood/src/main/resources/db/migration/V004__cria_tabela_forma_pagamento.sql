create table forma_pagamento
(
    id        BINARY(16) not null,
    descricao varchar(60),
    primary key (id)
) engine = InnoDB
  default charset = utf8;