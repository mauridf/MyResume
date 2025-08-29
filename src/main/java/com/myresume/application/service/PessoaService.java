package com.myresume.application.service;

import com.myresume.domain.model.Pessoa;
import com.myresume.domain.model.Usuario;
import com.myresume.infrastructure.repository.PessoaRepository;
import com.myresume.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final UsuarioRepository usuarioRepository;

    public PessoaService(PessoaRepository pessoaRepository, UsuarioRepository usuarioRepository) {
        this.pessoaRepository = pessoaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // Criar Pessoa vinculada a um Usuário
    public Pessoa criar(UUID usuarioId, Pessoa pessoa) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        pessoa.setUsuario(usuario);
        return pessoaRepository.save(pessoa);
    }

    // Buscar Pessoa pelo ID
    public Optional<Pessoa> buscarPorId(UUID id) {
        return pessoaRepository.findById(id);
    }

    // Listar todas Pessoas
    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    // Atualizar Pessoa
    public Pessoa atualizar(UUID id, Pessoa pessoaAtualizada) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        pessoa.setNome(pessoaAtualizada.getNome());
        pessoa.setTelefone(pessoaAtualizada.getTelefone());
        pessoa.setCidade(pessoaAtualizada.getCidade());
        pessoa.setUf(pessoaAtualizada.getUf());

        return pessoaRepository.save(pessoa);
    }

    // Excluir Pessoa
    public void excluir(UUID id) {
        if (!pessoaRepository.existsById(id)) {
            throw new RuntimeException("Pessoa não encontrada");
        }
        pessoaRepository.deleteById(id);
    }
}
