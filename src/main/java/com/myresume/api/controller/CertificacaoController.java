package com.myresume.api.controller;

import com.myresume.application.service.CertificacaoService;
import com.myresume.domain.model.Certificacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/certificacoes")
public class CertificacaoController {

    private final CertificacaoService service;

    public CertificacaoController(CertificacaoService service) {
        this.service = service;
    }

    @PostMapping("/{pessoaId}")
    public ResponseEntity<Certificacao> criar(
            @PathVariable UUID pessoaId,
            @RequestBody Certificacao certificacao) {
        return ResponseEntity.ok(service.criar(pessoaId, certificacao));
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<List<Certificacao>> listar(@PathVariable UUID pessoaId) {
        return ResponseEntity.ok(service.listar(pessoaId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable UUID id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

