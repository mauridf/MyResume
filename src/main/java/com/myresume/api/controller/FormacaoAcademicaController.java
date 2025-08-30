package com.myresume.api.controller;

import com.myresume.application.service.FormacaoAcademicaService;
import com.myresume.domain.model.FormacaoAcademica;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/formacoes")
public class FormacaoAcademicaController {

    private final FormacaoAcademicaService service;

    public FormacaoAcademicaController(FormacaoAcademicaService service) {
        this.service = service;
    }

    @PostMapping("/{pessoaId}")
    public ResponseEntity<FormacaoAcademica> criar(
            @PathVariable UUID pessoaId,
            @Valid @RequestBody FormacaoAcademica formacao) {
        return ResponseEntity.ok(service.criar(pessoaId, formacao));
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<List<FormacaoAcademica>> listar(@PathVariable UUID pessoaId) {
        return ResponseEntity.ok(service.listar(pessoaId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable UUID id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
