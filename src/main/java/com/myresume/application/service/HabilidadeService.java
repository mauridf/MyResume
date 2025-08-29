package com.myresume.application.service;

import com.myresume.domain.model.Pessoa;
import com.myresume.domain.model.Habilidade;
import com.myresume.infrastructure.repository.PessoaRepository;
import com.myresume.infrastructure.repository.HabilidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HabilidadeService {

    private final HabilidadeRepository repo;
    private final PessoaRepository pessoaRepo;

    public HabilidadeService(HabilidadeRepository repo, PessoaRepository pessoaRepo) {
        this.repo = repo;
        this.pessoaRepo = pessoaRepo;
    }

    public Habilidade criar(UUID pessoaId, Habilidade habilidade) {
        Pessoa pessoa = pessoaRepo.findById(pessoaId).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        habilidade.setPessoa(pessoa);
        return repo.save(habilidade);
    }

    public List<Habilidade> listar(UUID pessoaId) {
        return repo.findByPessoaId(pessoaId);
    }

    public void excluir(UUID id) {
        repo.deleteById(id);
    }
}

