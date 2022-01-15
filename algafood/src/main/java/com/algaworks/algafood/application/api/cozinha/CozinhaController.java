package com.algaworks.algafood.application.api.cozinha;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.cozinha.Cozinha;
import com.algaworks.algafood.domain.model.cozinha.CozinhaId;
import com.algaworks.algafood.domain.model.cozinha.CozinhaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    private CozinhaService cozinhaService;
    private CozinhaAssembler assembler;
    private CozinhaDisassembler disassembler;

    @GetMapping
    public List<CozinhaResponse> listar() {
        return assembler.toCollectionModel(this.cozinhaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable UUID id) {
        try {
            Cozinha cozinha = cozinhaService.buscar(new CozinhaId(id));
            return ResponseEntity.ok(assembler.toModel(cozinha));

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody CozinhaRequest cozinhaRequest) {
        try {
            Cozinha cozinha = disassembler.toDomain(cozinhaRequest);
            cozinhaService.adicionar(cozinha);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID id, @RequestBody CozinhaRequest cozinhaRequest) {
        try {
            Cozinha cozinha = disassembler.toDomain(id, cozinhaRequest);
            cozinhaService.atualizar(cozinha);
            return ResponseEntity.ok().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable UUID id) {
        try {
            cozinhaService.remover(new CozinhaId(id));
            return ResponseEntity.noContent().build();

        } catch (EntidadeEmUsoException e) {
           return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
