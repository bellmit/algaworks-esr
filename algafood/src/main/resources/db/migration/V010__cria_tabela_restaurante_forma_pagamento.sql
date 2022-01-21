create table restaurante_forma_pagamento
(
    restaurante_id     binary(16) not null,
    forma_pagamento_id binary(16) not null,

    primary key (restaurante_id, forma_pagamento_id)
) engine = InnoDB
  default charset = utf8;