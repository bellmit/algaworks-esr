package com.algaworks.algafood.infrastructure.persistence.database.mysql.service;

import com.algaworks.algafood.domain.model.restaurante.Restaurante;
import com.algaworks.algafood.domain.model.restaurante.RestauranteFactory;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.CozinhaModel;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.EnderecoModel;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.model.RestauranteModel;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.service.EnderecoTranslator;
import com.algaworks.algafood.infrastructure.persistence.database.mysql.service.FormaPagmentoTranslator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class RestauranteTranslator {

    private FormaPagmentoTranslator formaPagmentoTranslator;
    private EnderecoTranslator enderecoTranslator;

    public RestauranteModel toRestauranteModelFromRestaurante(Restaurante restaurante) {
        CozinhaModel cozinhaModel = new CozinhaModel();
        cozinhaModel.setId(restaurante.getCozinhaId().getId());

        RestauranteModel restauranteModel = new RestauranteModel();
        restauranteModel.setId(restaurante.getRestauranteId().getId());
        restauranteModel.setNome(restaurante.getNome());
        restauranteModel.setTaxaFrete(restaurante.getTaxaFrete());
        restauranteModel.setCozinha(cozinhaModel);
        restauranteModel.setFormaPagamentos(
                formaPagmentoTranslator.toCollectionFormaPagamentoModel(restaurante.getFormaPagamentos())
        );
        restauranteModel.setDataCadastro(restaurante.getDataCadastro());
        restauranteModel.setDataAtualizacao(restaurante.getDataAtualizacao());

        if (restaurante.getEndereco() != null) {
            restauranteModel.setEndereco(enderecoTranslator.toEnderecoModel(restaurante.getEndereco()));
        }

        return restauranteModel;
    }

    public Restaurante toRestauranteFromRestauranteModel(RestauranteModel restauranteModel) {
        List<UUID> ids = restauranteModel.getFormaPagamentos().stream()
                .map(model -> model.getId())
                .collect(Collectors.toList());

        EnderecoModel endereco = restauranteModel.getEndereco();

        RestauranteFactory factory = RestauranteFactory.builder(
                restauranteModel.getId(),
                restauranteModel.getNome(),
                restauranteModel.getTaxaFrete(),
                restauranteModel.getCozinha().getId(),
                restauranteModel.getDataCadastro(),
                restauranteModel.getDataAtualizacao()
        );

        if (!ids.isEmpty()) {
            factory.adicionarFormasPagamento(ids);
        }

        if (endereco != null) {
            factory.adicionarEndereco(
                    endereco.getCep(),
                    endereco.getLogradouro(),
                    endereco.getNumero(),
                    endereco.getComplemento(),
                    endereco.getBairro(),
                    endereco.getCidade().getId()
            );
        }

        return factory.build();
    }
}
