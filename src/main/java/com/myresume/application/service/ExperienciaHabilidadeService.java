package com.myresume.application.service;

import com.myresume.domain.model.Experiencia;
import com.myresume.domain.model.ExperienciaHabilidade;
import com.myresume.domain.model.Habilidade;
import com.myresume.infrastructure.repository.ExperienciaRepository;
import com.myresume.infrastructure.repository.ExperienciaHabilidadeRepository;
import com.myresume.infrastructure.repository.HabilidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExperienciaHabilidadeService {

    private final ExperienciaHabilidadeRepository repo;
    private final ExperienciaRepository experienciaRepo;
    private final HabilidadeRepository habilidadeRepo;

    public ExperienciaHabilidadeService(
            ExperienciaHabilidadeRepository repo,
            ExperienciaRepository experienciaRepo,
            HabilidadeRepository habilidadeRepo
    ) {
        this.repo = repo;
        this.experienciaRepo = experienciaRepo;
        this.habilidadeRepo = habilidadeRepo;
    }

    public ExperienciaHabilidade associar(UUID experienciaId, UUID habilidadeId) {
        Experiencia experiencia = experienciaRepo.findById(experienciaId)
                .orElseThrow(() -> new RuntimeException("Experiência não encontrada"));
        Habilidade habilidade = habilidadeRepo.findById(habilidadeId)
                .orElseThrow(() -> new RuntimeException("Habilidade não encontrada"));

        ExperienciaHabilidade eh = ExperienciaHabilidade.builder()
                .experiencia(experiencia)
                .habilidade(habilidade)
                .build();

        return repo.save(eh);
    }

    public List<ExperienciaHabilidade> listarPorExperiencia(UUID experienciaId) {
        return repo.findByExperienciaId(experienciaId);
    }

    public void desassociar(UUID id) {
        repo.deleteById(id);
    }
}

