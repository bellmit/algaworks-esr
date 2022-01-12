package com.algaworks.algafood.application.api;

import com.algaworks.algafood.application.api.request.RestauranteInput;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import com.algaworks.algafood.domain.model.restaurante.Restaurante;
import com.algaworks.algafood.domain.model.restaurante.RestauranteFactory;
import com.algaworks.algafood.domain.model.restaurante.RestauranteId;
import com.algaworks.algafood.domain.model.restaurante.RestauranteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    private RestauranteService restauranteService;

    @GetMapping
    public List<Restaurante> listar() {
        return this.restauranteService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable UUID id) {
        try {
            Restaurante restaurante = restauranteService.buscar(new RestauranteId(id));
            return ResponseEntity.ok(restaurante);

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody RestauranteInput input) {
        try {
            Restaurante restaurante = RestauranteFactory
                    .builder(UUID.randomUUID(), input.getNome(), input.getTaxaFrete(), input.getCozinhaId())
                    .build();

            restauranteService.adicionar(restaurante);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());

        } catch (PropriedadeInvalidaException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
