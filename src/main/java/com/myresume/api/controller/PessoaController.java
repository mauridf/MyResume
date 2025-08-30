package com.myresume.api.controller;

import com.myresume.application.service.PessoaService;
import com.myresume.domain.model.Pessoa;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    // Criar Pessoa vinculada ao usuário logado
    @PostMapping
    public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa, Authentication authentication) {
        UUID usuarioId = (UUID) authentication.getPrincipal();
        Pessoa novaPessoa = pessoaService.criar(usuarioId, pessoa);
        return ResponseEntity.ok(novaPessoa);
    }

    // Buscar Pessoa por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable UUID id) {
        return pessoaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Listar todas as Pessoas
    @GetMapping
    public ResponseEntity<List<Pessoa>> listar() {
        return ResponseEntity.ok(pessoaService.listar());
    }

    // Atualizar Pessoa
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable UUID id, @RequestBody Pessoa pessoaAtualizada) {
        Pessoa pessoa = pessoaService.atualizar(id, pessoaAtualizada);
        return ResponseEntity.ok(pessoa);
    }

    // Excluir Pessoa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable UUID id) {
        pessoaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
