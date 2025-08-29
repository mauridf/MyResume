package com.myresume.infrastructure.repository;

import com.myresume.domain.model.RedeSocial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RedeSocialRepository extends JpaRepository<RedeSocial, UUID> {
    List<RedeSocial> findByPessoaId(UUID pessoaId);
}
