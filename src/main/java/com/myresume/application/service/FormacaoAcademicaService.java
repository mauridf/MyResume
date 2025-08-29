package com.myresume.application.service;

import com.myresume.domain.model.Pessoa;
import com.myresume.domain.model.FormacaoAcademica;
import com.myresume.infrastructure.repository.PessoaRepository;
import com.myresume.infrastructure.repository.FormacaoAcademicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FormacaoAcademicaService {

    private final FormacaoAcademicaRepository repo;
    private final PessoaRepository pessoaRepo;

    public FormacaoAcademicaService(FormacaoAcademicaRepository repo, PessoaRepository pessoaRepo) {
        this.repo = repo;
        this.pessoaRepo = pessoaRepo;
    }

    public FormacaoAcademica criar(UUID pessoaId, FormacaoAcademica formacao) {
        Pessoa pessoa = pessoaRepo.findById(pessoaId)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        formacao.setPessoa(pessoa);
        return repo.save(formacao);
    }

    public List<FormacaoAcademica> listar(UUID pessoaId) {
        return repo.findByPessoaId(pessoaId);
    }

    public void excluir(UUID id) {
        repo.deleteById(id);
    }
}
