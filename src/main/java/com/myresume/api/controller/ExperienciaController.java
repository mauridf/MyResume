package com.myresume.api.controller;

import com.myresume.application.service.ExperienciaService;
import com.myresume.domain.model.Experiencia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/experiencias")
public class ExperienciaController {

    private final ExperienciaService service;

    public ExperienciaController(ExperienciaService service) {
        this.service = service;
    }

    @PostMapping("/{pessoaId}")
    public ResponseEntity<Experiencia> criar(@PathVariable UUID pessoaId, @RequestBody Experiencia experiencia) {
        return ResponseEntity.ok(service.criar(pessoaId, experiencia));
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<List<Experiencia>> listar(@PathVariable UUID pessoaId) {
        return ResponseEntity.ok(service.listar(pessoaId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable UUID id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

