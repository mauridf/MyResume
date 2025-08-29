package com.myresume.application.service;

import com.myresume.domain.model.Usuario;
import com.myresume.infrastructure.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Cadastro de novo usuário
    public Usuario cadastrar(String email, String senha) {
        if (usuarioRepository.existsByEmail(email)) {
            throw new RuntimeException("E-mail já cadastrado!");
        }

        String senhaHash = passwordEncoder.encode(senha);

        Usuario usuario = Usuario.builder()
                .email(email)
                .senhaHash(senhaHash)
                .build();

        return usuarioRepository.save(usuario);
    }

    // Autenticação (login)
    public Optional<Usuario> autenticar(String email, String senha) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (passwordEncoder.matches(senha, usuario.getSenhaHash())) {
                return Optional.of(usuario);
            }
        }

        return Optional.empty();
    }

    // Buscar usuário por ID
    public Optional<Usuario> buscarPorId(UUID id) {
        return usuarioRepository.findById(id);
    }
}
