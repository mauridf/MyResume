package com.myresume.api.controller;

import com.myresume.application.service.ExperienciaHabilidadeService;
import com.myresume.domain.model.ExperienciaHabilidade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/experiencia-habilidades")
public class ExperienciaHabilidadeController {

    private final ExperienciaHabilidadeService service;

    public ExperienciaHabilidadeController(ExperienciaHabilidadeService service) {
        this.service = service;
    }

    @PostMapping("/{experienciaId}/habilidade/{habilidadeId}")
    public ResponseEntity<ExperienciaHabilidade> associar(
            @PathVariable UUID experienciaId,
            @PathVariable UUID habilidadeId) {
        return ResponseEntity.ok(service.associar(experienciaId, habilidadeId));
    }

    @GetMapping("/{experienciaId}")
    public ResponseEntity<List<ExperienciaHabilidade>> listar(@PathVariable UUID experienciaId) {
        return ResponseEntity.ok(service.listarPorExperiencia(experienciaId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desassociar(@PathVariable UUID id) {
        service.desassociar(id);
        return ResponseEntity.noContent().build();
    }
}

