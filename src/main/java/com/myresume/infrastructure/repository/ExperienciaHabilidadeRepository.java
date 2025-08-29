package com.myresume.infrastructure.repository;

import com.myresume.domain.model.ExperienciaHabilidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ExperienciaHabilidadeRepository extends JpaRepository<ExperienciaHabilidade, UUID> {
    List<ExperienciaHabilidade> findByExperienciaId(UUID experienciaId);
}
