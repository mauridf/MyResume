package com.myresume.infrastructure.repository;

import com.myresume.domain.model.ResumoProfissional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ResumoProfissionalRepository extends JpaRepository<ResumoProfissional, UUID> {
    List<ResumoProfissional> findByPessoaId(UUID pessoaId);
}

