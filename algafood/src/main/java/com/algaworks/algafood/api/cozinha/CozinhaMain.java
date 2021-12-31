package com.algaworks.algafood.api.cozinha;

import com.algaworks.algafood.AlgafoodApplication;
import com.algaworks.algafood.domain.cozinha.Cozinha;
import com.algaworks.algafood.infrastructure.cozinha.MysqlCozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;


import java.util.List;

public class CozinhaMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        MysqlCozinhaRepository repository = applicationContext.getBean(MysqlCozinhaRepository.class);

        List<Cozinha> cozinhas = repository.listarTodas();

        for (Cozinha cozinha : cozinhas) {
            System.out.println(cozinha.getNome());
        }
    }
}
