package com.myresume.api.controller;

import com.myresume.application.service.IdiomaService;
import com.myresume.domain.model.Idioma;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/idiomas")
public class IdiomaController {

    private final IdiomaService service;

    public IdiomaController(IdiomaService service) {
        this.service = service;
    }

    @PostMapping("/{pessoaId}")
    public ResponseEntity<Idioma> criar(
            @PathVariable UUID pessoaId,
            @Valid @RequestBody Idioma idioma) {
        return ResponseEntity.ok(service.criar(pessoaId, idioma));
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<List<Idioma>> listar(@PathVariable UUID pessoaId) {
        return ResponseEntity.ok(service.listar(pessoaId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable UUID id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
