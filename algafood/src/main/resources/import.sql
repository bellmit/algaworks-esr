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