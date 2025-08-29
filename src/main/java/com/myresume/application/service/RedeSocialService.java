package com.myresume.application.service;

import com.myresume.domain.model.Pessoa;
import com.myresume.domain.model.RedeSocial;
import com.myresume.infrastructure.repository.PessoaRepository;
import com.myresume.infrastructure.repository.RedeSocialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RedeSocialService {

    private final RedeSocialRepository redeSocialRepository;
    private final PessoaRepository pessoaRepository;

    public RedeSocialService(RedeSocialRepository redeSocialRepository, PessoaRepository pessoaRepository) {
        this.redeSocialRepository = redeSocialRepository;
        this.pessoaRepository = pessoaRepository;
    }

    public RedeSocial criar(UUID pessoaId, RedeSocial redeSocial) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        redeSocial.setPessoa(pessoa);
        return redeSocialRepository.save(redeSocial);
    }

    public List<RedeSocial> listarPorPessoa(UUID pessoaId) {
        return redeSocialRepository.findByPessoaId(pessoaId);
    }

    public void excluir(UUID id) {
        redeSocialRepository.deleteById(id);
    }
}
