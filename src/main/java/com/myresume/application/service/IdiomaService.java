package com.myresume.application.service;

import com.myresume.domain.model.Pessoa;
import com.myresume.domain.model.Idioma;
import com.myresume.infrastructure.repository.PessoaRepository;
import com.myresume.infrastructure.repository.IdiomaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IdiomaService {

    private final IdiomaRepository repo;
    private final PessoaRepository pessoaRepo;

    public IdiomaService(IdiomaRepository repo, PessoaRepository pessoaRepo) {
        this.repo = repo;
        this.pessoaRepo = pessoaRepo;
    }

    public Idioma criar(UUID pessoaId, Idioma idioma) {
        Pessoa pessoa = pessoaRepo.findById(pessoaId)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        idioma.setPessoa(pessoa);
        return repo.save(idioma);
    }

    public List<Idioma> listar(UUID pessoaId) {
        return repo.findByPessoaId(pessoaId);
    }

    public void excluir(UUID id) {
        repo.deleteById(id);
    }
}

