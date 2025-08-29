package com.myresume.application.service;

import com.myresume.domain.model.Pessoa;
import com.myresume.domain.model.Experiencia;
import com.myresume.infrastructure.repository.PessoaRepository;
import com.myresume.infrastructure.repository.ExperienciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExperienciaService {

    private final ExperienciaRepository repo;
    private final PessoaRepository pessoaRepo;

    public ExperienciaService(ExperienciaRepository repo, PessoaRepository pessoaRepo) {
        this.repo = repo;
        this.pessoaRepo = pessoaRepo;
    }

    public Experiencia criar(UUID pessoaId, Experiencia experiencia) {
        Pessoa pessoa = pessoaRepo.findById(pessoaId).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        experiencia.setPessoa(pessoa);
        return repo.save(experiencia);
    }

    public List<Experiencia> listar(UUID pessoaId) {
        return repo.findByPessoaId(pessoaId);
    }

    public void excluir(UUID id) {
        repo.deleteById(id);
    }
}

