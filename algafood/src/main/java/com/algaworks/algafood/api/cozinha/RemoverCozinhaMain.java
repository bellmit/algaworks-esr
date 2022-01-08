package com.algaworks.algafood.api.cozinha;

import com.algaworks.algafood.AlgafoodApplication;
import com.algaworks.algafood.application.cozinha.AdicionarCozinhaCommand;
import com.algaworks.algafood.application.cozinha.CozinhaApplicationService;
import com.algaworks.algafood.application.cozinha.RemoverCozinhaCommand;
import com.algaworks.algafood.domain.model.cozinha.Cozinha;
import com.algaworks.algafood.domain.model.cozinha.CozinhaDomainService;
import com.algaworks.algafood.port.adapter.persistence.repository.MysqlCozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

public class RemoverCozinhaMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        MysqlCozinhaRepository repository = applicationContext.getBean(MysqlCozinhaRepository.class);

        CozinhaDomainService domainService = new CozinhaDomainService(repository);

        CozinhaApplicationService service = new CozinhaApplicationService(domainService);

        AdicionarCozinhaCommand command = new AdicionarCozinhaCommand("Portuguesa");

        service.adicionarCozinha(command);

        List<Cozinha> cozinhas = repository.listar();

        for (Cozinha cozinha : cozinhas) {
            System.out.println(cozinha.getNome());
        }

        Optional<Cozinha> indiana = repository.buscarPeloNome("Portuguesa");

        RemoverCozinhaCommand command2 = new RemoverCozinhaCommand(indiana.get().getId());

        service.removerCozinha(command2);

        cozinhas = repository.listar();

        for (Cozinha cozinha : cozinhas) {
            System.out.println(cozinha.getNome());
        }
    }
}
