SET @cozinhaTailandesa = unhex(replace(uuid(), '-', ''));
SET @cozinhaIndiana = unhex(replace(uuid(), '-', ''));

insert into cozinha (id, nome) values (@cozinhaTailandesa, 'Tailandesa');
insert into cozinha (id, nome) values (@cozinhaIndiana, 'Indiana');

SET @retauranteThaiGourmet = unhex(replace(uuid(), '-', ''));
SET @restauranteThaiDelivery = unhex(replace(uuid(), '-', ''));
SET @restauranteTuktuk = unhex(replace(uuid(), '-', ''));

insert restaurante (id, nome, taxa_frete, cozinha_id)  values (@retauranteThaiGourmet, 'Thai Gourmet', 10, @cozinhaTailandesa);
insert restaurante (id, nome, taxa_frete, cozinha_id)  values (@restauranteThaiDelivery, 'Thai Delivery', 9.50, @cozinhaTailandesa);
insert restaurante (id, nome, taxa_frete, cozinha_id)  values (@restauranteTuktuk, 'Tuk Tuk Comida Indiana', 15, @cozinhaIndiana);

SET @estadoMinasGerais = unhex(replace(uuid(), '-', ''));
SET @estadoSaoPaulo = unhex(replace(uuid(), '-', ''));
SET @estadoCeara = unhex(replace(uuid(), '-', ''));

insert estado (id, nome) values (@estadoMinasGerais, 'Minas Gerais');
insert estado (id, nome) values (@estadoSaoPaulo, 'São Paulo');
insert estado (id, nome) values (@estadoCeara, 'Ceará');

SET @cidadeUberlandia = unhex(replace(uuid(), '-', ''));
SET @cidadeBeloHorizonte = unhex(replace(uuid(), '-', ''));
SET @cidadeSaoPaulo = unhex(replace(uuid(), '-', ''));
SET @cidadeCampinas = unhex(replace(uuid(), '-', ''));
SET @cidadeFortaleza = unhex(replace(uuid(), '-', ''));

insert cidade (id, nome, estado_id) values (@cidadeUberlandia, 'Uberlândia', @estadoMinasGerais);
insert cidade (id, nome, estado_id) values (@cidadeBeloHorizonte, 'Belo Horizonte', @estadoMinasGerais);
insert cidade (id, nome, estado_id) values (@cidadeSaoPaulo, 'São Paulo', @estadoSaoPaulo);
insert cidade (id, nome, estado_id) values (@cidadeCampinas, 'Campinas', @estadoSaoPaulo);
insert cidade (id, nome, estado_id) values (@cidadeFortaleza, 'Fortaleza', @estadoCeara);

SET @cartaoCredito = unhex(replace(uuid(), '-', ''));
SET @cartaoDebito = unhex(replace(uuid(), '-', ''));
SET @dinheiro = unhex(replace(uuid(), '-', ''));

insert into forma_pagamento (id, descricao) values (@cartaoCredito, 'Cartão de crédito');
insert into forma_pagamento (id, descricao) values (@cartaoDebito, 'Cartão de débito');
insert into forma_pagamento (id, descricao) values (@dinheiro, 'Dinheiro');

SET @consultarCozinhas = unhex(replace(uuid(), '-', ''));
SET @editarCozinhas = unhex(replace(uuid(), '-', ''));

insert into permissao (id, nome, descricao) values (@consultarCozinhas, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (id, nome, descricao) values (@editarCozinhas, 'EDITAR_COZINHAS', 'Permite editar cozinhas');