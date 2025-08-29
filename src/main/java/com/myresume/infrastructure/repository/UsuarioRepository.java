package com.myresume.infrastructure.repository;

import com.myresume.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    // Encontrar usuário pelo e-mail (para login/autenticação)
    Optional<Usuario> findByEmail(String email);

    // Verificar se já existe e-mail cadastrado
    boolean existsByEmail(String email);
}
