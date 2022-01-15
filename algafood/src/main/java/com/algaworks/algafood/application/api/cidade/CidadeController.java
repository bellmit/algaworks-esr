package com.algaworks.algafood.application.api.cidade;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.PropriedadeInvalidaException;
import com.algaworks.algafood.domain.model.cidade.Cidade;
import com.algaworks.algafood.domain.model.cidade.CidadeId;
import com.algaworks.algafood.domain.model.cidade.CidadeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/cidades")
public class CidadeController {

    private CidadeService cidadeService;
    private CidadeAssembler assembler;
    private CidadeDisassembler disassembler;

    @GetMapping
    public List<CidadeResponse> listar() {
        return assembler.toCollectionModel(cidadeService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable UUID id) {
        try {
            Cidade cidade = cidadeService.buscar(new CidadeId(id));
            return ResponseEntity.ok(assembler.toModel(cidade));

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody CidadeRequest cidadeRequest) {
        try {
            Cidade cidade = disassembler.toDomain(cidadeRequest);
            cidadeService.adicionar(cidade);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());

        } catch (PropriedadeInvalidaException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID id, @RequestBody CidadeRequest cidadeRequest) {
        try {
            Cidade cidade = disassembler.toDomain(id, cidadeRequest);
            cidadeService.atualizar(cidade);
            return ResponseEntity.ok().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());

        } catch (PropriedadeInvalidaException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable UUID id) {
        try {
            CidadeId cidadeId = new CidadeId(id);
            cidadeService.remover(cidadeId);
            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
