package com.myresume.application.service;

import com.myresume.domain.model.Certificacao;
import com.myresume.domain.model.Pessoa;
import com.myresume.infrastructure.repository.CertificacaoRepository;
import com.myresume.infrastructure.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CertificacaoService {

    private final CertificacaoRepository repo;
    private final PessoaRepository pessoaRepo;

    public CertificacaoService(CertificacaoRepository repo, PessoaRepository pessoaRepo) {
        this.repo = repo;
        this.pessoaRepo = pessoaRepo;
    }

    public Certificacao criar(UUID pessoaId, Certificacao certificacao) {
        Pessoa pessoa = pessoaRepo.findById(pessoaId)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        certificacao.setPessoa(pessoa);
        return repo.save(certificacao);
    }

    public List<Certificacao> listar(UUID pessoaId) {
        return repo.findByPessoaId(pessoaId);
    }

    public void excluir(UUID id) {
        repo.deleteById(id);
    }
}
