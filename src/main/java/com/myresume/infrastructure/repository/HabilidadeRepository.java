package com.myresume.infrastructure.repository;

import com.myresume.domain.model.Habilidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HabilidadeRepository extends JpaRepository<Habilidade, UUID> {
    List<Habilidade> findByPessoaId(UUID pessoaId);
}

