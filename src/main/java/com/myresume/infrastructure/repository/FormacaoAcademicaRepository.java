package com.myresume.infrastructure.repository;

import com.myresume.domain.model.FormacaoAcademica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FormacaoAcademicaRepository extends JpaRepository<FormacaoAcademica, UUID> {
    List<FormacaoAcademica> findByPessoaId(UUID pessoaId);
}
