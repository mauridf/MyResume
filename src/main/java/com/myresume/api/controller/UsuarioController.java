package com.myresume.api.controller;

import com.myresume.application.service.UsuarioService;
import com.myresume.domain.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.myresume.infrastructure.security.JwtUtil;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final JwtUtil jwtUtil;

    public UsuarioController(UsuarioService usuarioService, JwtUtil jwtUtil) {
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
    }

    // Cadastro de usuário
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@Valid @RequestBody Map<String, String> body) {
        String email = body.get("email");
        String senha = body.get("senha");

        Usuario usuario = usuarioService.cadastrar(email, senha);
        return ResponseEntity.ok(usuario);
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String senha = body.get("senha");

        return usuarioService.autenticar(email, senha)
                .map(usuario -> {
                    String token = jwtUtil.gerarToken(usuario.getId());
                    return ResponseEntity.ok(Map.<String, Object>of(
                            "token", token,
                            "id", usuario.getId(),
                            "email", usuario.getEmail()
                    ));
                })
                .orElse(ResponseEntity.status(401).body(Map.<String, Object>of(
                        "message", "Credenciais inválidas"
                )));
    }
}
