package com.algaworks.algafood.api.cozinha;

import com.algaworks.algafood.AlgafoodApplication;
import com.algaworks.algafood.application.cozinha.AdicionarCozinhaCommand;
import com.algaworks.algafood.application.cozinha.AtualizarCozinhaCommand;
import com.algaworks.algafood.application.cozinha.CozinhaApplicationService;
import com.algaworks.algafood.domain.model.cozinha.Cozinha;
import com.algaworks.algafood.port.adapter.persistence.repository.MysqlCozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class AtualizarCozinhaMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        MysqlCozinhaRepository repository = applicationContext.getBean(MysqlCozinhaRepository.class);

        CozinhaApplicationService service = new CozinhaApplicationService(repository);

        AtualizarCozinhaCommand command = new AtualizarCozinhaCommand("Indiana", "Indiana 2");

        service.atualizarCozinha(command);

        List<Cozinha> cozinhas = repository.listar();

        for (Cozinha cozinha : cozinhas) {
            System.out.println(cozinha.getNome());
        }
    }
}
