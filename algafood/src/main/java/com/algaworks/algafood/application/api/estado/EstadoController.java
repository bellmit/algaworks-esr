package com.algaworks.algafood.application.api.estado;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.estado.Estado;
import com.algaworks.algafood.domain.model.estado.EstadoId;
import com.algaworks.algafood.domain.model.estado.EstadoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/estados")
public class EstadoController {

    private EstadoService estadoService;
    private EstadoAssembler assembler;
    private EstadoDisassembler disassembler;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable UUID id) {
        EstadoId estadoId = new EstadoId(id);
        try {
            EstadoResponse estadoResponse = assembler.toModel(estadoService.buscar(estadoId));
            return ResponseEntity.ok(estadoResponse);

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public List<EstadoResponse> listar() {
        return assembler.toCollectionModel(estadoService.listar());
    }

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody EstadoRequest estadoRequest) {
        try {
            Estado estado = this.disassembler.toDomain(estadoRequest);
            estadoService.adicionar(estado);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID id, @RequestBody EstadoRequest estadoRequest) {
        try {
            Estado estado = this.disassembler.toDomain(id, estadoRequest);
            estadoService.atualizar(estado);
            return ResponseEntity.ok().build();

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
