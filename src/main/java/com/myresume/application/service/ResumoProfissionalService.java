package com.myresume.application.service;

import com.myresume.domain.model.Pessoa;
import com.myresume.domain.model.ResumoProfissional;
import com.myresume.infrastructure.repository.PessoaRepository;
import com.myresume.infrastructure.repository.ResumoProfissionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ResumoProfissionalService {

    private final ResumoProfissionalRepository repo;
    private final PessoaRepository pessoaRepo;

    public ResumoProfissionalService(ResumoProfissionalRepository repo, PessoaRepository pessoaRepo) {
        this.repo = repo;
        this.pessoaRepo = pessoaRepo;
    }

    public ResumoProfissional criar(UUID pessoaId, ResumoProfissional resumo) {
        Pessoa pessoa = pessoaRepo.findById(pessoaId).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        resumo.setPessoa(pessoa);
        return repo.save(resumo);
    }

    public List<ResumoProfissional> listar(UUID pessoaId) {
        return repo.findByPessoaId(pessoaId);
    }

    public void excluir(UUID id) {
        repo.deleteById(id);
    }
}

