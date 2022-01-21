alter table restaurante
    add constraint fk_restaurante_cozinha
        foreign key (cozinha_id) references cozinha (id);

alter table restaurante
    add constraint fk_restaurante_cidade
        foreign key (endereco_cidade_id) references cidade (id);