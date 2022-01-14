package com.algaworks.algafood.application.api.restaurante;

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
    private RestauranteAssembler assembler;
    private RestauranteDisassembler disassembler;

    @GetMapping
    public List<RestauranteResponse> listar() {
        return assembler.toCollectionModel(this.restauranteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable UUID id) {
        try {
            Restaurante restaurante = restauranteService.buscar(new RestauranteId(id));
            return ResponseEntity.ok(assembler.toModel(restaurante));

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody RestauranteRequest request) {
        try {
            Restaurante restaurante = disassembler.toDomain(request);
            restauranteService.adicionar(restaurante);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());

        } catch (PropriedadeInvalidaException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID id, @RequestBody RestauranteRequest request) {
        try {
            Restaurante restaurante = disassembler.toDomain(id, request);
            restauranteService.atualizar(restaurante);
            return ResponseEntity.status(HttpStatus.OK).build();

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());

        } catch (PropriedadeInvalidaException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable UUID id) {
        try {
            RestauranteId restauranteId = new RestauranteId(id);
            restauranteService.remover(restauranteId);
            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        } catch (PropriedadeInvalidaException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
