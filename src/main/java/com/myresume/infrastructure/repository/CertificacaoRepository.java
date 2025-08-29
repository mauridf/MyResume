package com.myresume.infrastructure.repository;

import com.myresume.domain.model.Certificacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CertificacaoRepository extends JpaRepository<Certificacao, UUID> {
    List<Certificacao> findByPessoaId(UUID pessoaId);
}

