package com.myresume.api.controller;

import com.myresume.application.service.HabilidadeService;
import com.myresume.domain.model.Habilidade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/habilidades")
public class HabilidadeController {

    private final HabilidadeService service;

    public HabilidadeController(HabilidadeService service) {
        this.service = service;
    }

    @PostMapping("/{pessoaId}")
    public ResponseEntity<Habilidade> criar(@PathVariable UUID pessoaId, @RequestBody Habilidade habilidade) {
        return ResponseEntity.ok(service.criar(pessoaId, habilidade));
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<List<Habilidade>> listar(@PathVariable UUID pessoaId) {
        return ResponseEntity.ok(service.listar(pessoaId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable UUID id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

