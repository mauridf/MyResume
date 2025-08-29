package com.myresume.api.controller;

import com.myresume.application.service.RedeSocialService;
import com.myresume.domain.model.RedeSocial;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/redes-sociais")
public class RedeSocialController {

    private final RedeSocialService redeSocialService;

    public RedeSocialController(RedeSocialService redeSocialService) {
        this.redeSocialService = redeSocialService;
    }

    @PostMapping("/{pessoaId}")
    public ResponseEntity<RedeSocial> criar(@PathVariable UUID pessoaId, @RequestBody RedeSocial redeSocial) {
        return ResponseEntity.ok(redeSocialService.criar(pessoaId, redeSocial));
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<List<RedeSocial>> listar(@PathVariable UUID pessoaId) {
        return ResponseEntity.ok(redeSocialService.listarPorPessoa(pessoaId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable UUID id) {
        redeSocialService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
