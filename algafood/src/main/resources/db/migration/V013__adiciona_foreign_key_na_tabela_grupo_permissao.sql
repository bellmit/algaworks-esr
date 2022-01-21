alter table grupo_permissao
    add constraint fk_grupo_permissao_permissao
        foreign key (permissao_id) references permissao (id);

alter table grupo_permissao
    add constraint fk_grupo_permissao_grupo
        foreign key (grupo_id) references grupo (id);