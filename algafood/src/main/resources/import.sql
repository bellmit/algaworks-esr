SET @cozinhaTailandesa = unhex(replace(uuid(), '-', ''));
SET @cozinhaIndiana = unhex(replace(uuid(), '-', ''));

insert into cozinha values (@cozinhaTailandesa, 'Tailandesa');
insert into cozinha values (@cozinhaIndiana, 'Indiana');

SET @retauranteThaiGourmet = unhex(replace(uuid(), '-', ''));
SET @restauranteThaiDelivery = unhex(replace(uuid(), '-', ''));
SET @restauranteTuktuk = unhex(replace(uuid(), '-', ''));

insert into restaurante  values (@retauranteThaiGourmet, 'Thai Gourmet', 10, @cozinhaTailandesa);
insert into restaurante  values (@restauranteThaiDelivery, 'Thai Delivery', 9.50, @cozinhaTailandesa);
insert into restaurante  values (@restauranteTuktuk, 'Tuk Tuk Comida Indiana', 15, @cozinhaIndiana);

SET @estadoMinasGerais = unhex(replace(uuid(), '-', ''));
SET @estadoSaoPaulo = unhex(replace(uuid(), '-', ''));
SET @estadoCeara = unhex(replace(uuid(), '-', ''));

insert into estado values (@estadoMinasGerais, 'Minas Gerais');
insert into estado values (@estadoSaoPaulo, 'São Paulo');
insert into estado values (@estadoCeara, 'Ceará');

SET @cidadeUberlandia = unhex(replace(uuid(), '-', ''));
SET @cidadeBeloHorizonte = unhex(replace(uuid(), '-', ''));
SET @cidadeSaoPaulo = unhex(replace(uuid(), '-', ''));
SET @cidadeCampinas = unhex(replace(uuid(), '-', ''));
SET @cidadeFortaleza = unhex(replace(uuid(), '-', ''));

insert into cidade values (@cidadeUberlandia, 'Uberlândia', @estadoMinasGerais);
insert into cidade values (@cidadeBeloHorizonte, 'Belo Horizonte', @estadoMinasGerais);
insert into cidade values (@cidadeSaoPaulo, 'São Paulo', @estadoSaoPaulo);
insert into cidade values (@cidadeCampinas, 'Campinas', @estadoSaoPaulo);
insert into cidade values (@cidadeFortaleza, 'Fortaleza', @estadoCeara);