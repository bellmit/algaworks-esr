package com.algaworks.algafood.domain.model.restaurante;

import com.algaworks.algafood.domain.model.cidade.CidadeId;
import com.algaworks.algafood.domain.model.cozinha.CozinhaId;
import com.algaworks.algafood.domain.model.endereco.Endereco;
import com.algaworks.algafood.domain.model.formapagamento.FormaPagamentoId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class RestauranteFactory {

    private Restaurante restaurante;

    private RestauranteFactory(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public static RestauranteFactory builder(
            UUID restauranteId,
            String nome,
            BigDecimal taxaFrete,
            UUID cozinhaId,
            LocalDateTime dataCadastro,
            LocalDateTime dataAtualizacao) {

        Restaurante novoRestaurante = new Restaurante(
                new RestauranteId(restauranteId),
                nome,
                taxaFrete,
                new CozinhaId(cozinhaId),
                dataCadastro,
                dataAtualizacao
        );
        return new RestauranteFactory(novoRestaurante);
    }

    public RestauranteFactory adicionarFormasPagamento(List<UUID> ids) {
        ids.forEach(id -> this.restaurante.adicionarFormaPagamento(new FormaPagamentoId(id)));
        return this;
    }

    public RestauranteFactory adicionarEndereco(Endereco endereco) {
        this.restaurante.adicionarEndereco(endereco);
        return this;
    }

    public RestauranteFactory adicionarEndereco(
            String cep,
            String logradouro,
            String numero,
            String complemento,
            String bairro,
            UUID cidadeId
    ) {
        Endereco endereco = new Endereco(
                cep,
                logradouro,
                numero,
                complemento,
                bairro,
                new CidadeId(cidadeId)
        );
        this.restaurante.adicionarEndereco(endereco);
        return this;
    }

    public Restaurante build() {
        return this.restaurante;
    }
}
