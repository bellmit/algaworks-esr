alter table produto
    add constraint fk_produto_restaurante
        foreign key (restaurante_id) references restaurante (id);