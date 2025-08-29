package com.myresume.infrastructure.repository;

import com.myresume.domain.model.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IdiomaRepository extends JpaRepository<Idioma, UUID> {
    List<Idioma> findByPessoaId(UUID pessoaId);
}

