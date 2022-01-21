SET @cozinhaTailandesa = unhex(replace(uuid(), '-', ''));
SET @cozinhaIndiana = unhex(replace(uuid(), '-', ''));
SET @cozinhaArgentina = unhex(replace(uuid(), '-', ''));
SET @cozinhaBrasileira = unhex(replace(uuid(), '-', ''));

insert into cozinha (id, nome) values (@cozinhaTailandesa, 'Tailandesa');
insert into cozinha (id, nome) values (@cozinhaIndiana, 'Indiana');
insert into cozinha (id, nome) values (@cozinhaArgentina, 'Argentina');
insert into cozinha (id, nome) values (@cozinhaBrasileira, 'Brasileira');

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

SET @retauranteThaiGourmet = unhex(replace(uuid(), '-', ''));
SET @restauranteThaiDelivery = unhex(replace(uuid(), '-', ''));
SET @restauranteTuktuk = unhex(replace(uuid(), '-', ''));
SET @restauranteJavaSteakhouse = unhex(replace(uuid(), '-', ''));
SET @restauranteTioSam = unhex(replace(uuid(), '-', ''));
SET @restauranteBarMaria = unhex(replace(uuid(), '-', ''));

insert restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro)  values (@retauranteThaiGourmet, 'Thai Gourmet', 10, @cozinhaTailandesa, utc_timestamp, utc_timestamp, @cidadeUberlandia, '38400-999', 'Rua João Pinheiro', '1000', 'Centro');
insert restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao)  values (@restauranteThaiDelivery, 'Thai Delivery', 9.50, @cozinhaTailandesa, utc_timestamp, utc_timestamp);
insert restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao)  values (@restauranteTuktuk, 'Tuk Tuk Comida Indiana', 15, @cozinhaIndiana, utc_timestamp, utc_timestamp);
insert restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (@restauranteJavaSteakhouse, 'Java Steakhouse', 12, @cozinhaArgentina, utc_timestamp, utc_timestamp);
insert restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (@restauranteTioSam, 'Lanchonete do Tio Sam', 11, @cozinhaBrasileira, utc_timestamp, utc_timestamp);
insert restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (@restauranteBarMaria, 'Bar da Maria', 6, @cozinhaBrasileira, utc_timestamp, utc_timestamp);

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

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (@retauranteThaiGourmet, @cartaoCredito);
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (@retauranteThaiGourmet, @cartaoDebito);
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (@retauranteThaiGourmet, @dinheiro);
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (@restauranteThaiDelivery, @dinheiro);
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (@restauranteTuktuk, @cartaoDebito);
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (@restauranteTuktuk, @dinheiro);

SET @produtoPorcoMoloAgridoce = unhex(replace(uuid(), '-', ''));
SET @produtoCamaraoTailandes = unhex(replace(uuid(), '-', ''));
SET @produtoSaladaPicante = unhex(replace(uuid(), '-', ''));
SET @produtoGarlicNaan = unhex(replace(uuid(), '-', ''));
SET @produtoMurgCurry = unhex(replace(uuid(), '-', ''));
SET @produtoBifeAncho = unhex(replace(uuid(), '-', ''));
SET @produtoBifeAncho = unhex(replace(uuid(), '-', ''));
SET @produtoTbone = unhex(replace(uuid(), '-', ''));
SET @produtoXtudo = unhex(replace(uuid(), '-', ''));
SET @produtoEspetinhoCupin = unhex(replace(uuid(), '-', ''));

insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (@produtoPorcoMoloAgridoce, 'Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, 1, @retauranteThaiGourmet);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (@produtoCamaraoTailandes, 'Camarão tailandês', '16 camarões grandes ao molho picante', 110, 1, @retauranteThaiGourmet);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (@produtoSaladaPicante,'Salada picante com carne grelhada', 'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha', 87.20, 1, @restauranteThaiDelivery);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (@produtoGarlicNaan, 'Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, 1, @restauranteTuktuk);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (@produtoMurgCurry, 'Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, 1, @restauranteTuktuk);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (@produtoBifeAncho, 'Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, 1, @restauranteJavaSteakhouse);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (@produtoTbone, 'T-Bone', 'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon', 89, 1, @restauranteJavaSteakhouse);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (@produtoXtudo, 'Sanduíche X-Tudo', 'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese', 19, 1, @restauranteTioSam);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (@produtoEspetinhoCupin, 'Espetinho de Cupim', 'Acompanha farinha, mandioca e vinagrete', 8, 1, @restauranteBarMaria);