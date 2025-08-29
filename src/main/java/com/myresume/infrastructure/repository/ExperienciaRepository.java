package com.myresume.infrastructure.repository;

import com.myresume.domain.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ExperienciaRepository extends JpaRepository<Experiencia, UUID> {
    List<Experiencia> findByPessoaId(UUID pessoaId);
}

