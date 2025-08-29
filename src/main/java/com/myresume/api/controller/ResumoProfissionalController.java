package com.myresume.api.controller;

import com.myresume.application.service.ResumoProfissionalService;
import com.myresume.domain.model.ResumoProfissional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/resumos")
public class ResumoProfissionalController {

    private final ResumoProfissionalService service;

    public ResumoProfissionalController(ResumoProfissionalService service) {
        this.service = service;
    }

    @PostMapping("/{pessoaId}")
    public ResponseEntity<ResumoProfissional> criar(@PathVariable UUID pessoaId, @RequestBody ResumoProfissional resumo) {
        return ResponseEntity.ok(service.criar(pessoaId, resumo));
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<List<ResumoProfissional>> listar(@PathVariable UUID pessoaId) {
        return ResponseEntity.ok(service.listar(pessoaId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable UUID id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

