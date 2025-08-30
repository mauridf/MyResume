package com.myresume.application.service;

import com.myresume.domain.model.Pessoa;
import com.myresume.infrastructure.repository.CertificacaoRepository;
import com.myresume.infrastructure.repository.PessoaRepository;
import com.myresume.infrastructure.repository.ResumoProfissionalRepository;
import com.myresume.infrastructure.repository.HabilidadeRepository;
import com.myresume.infrastructure.repository.ExperienciaRepository;
import com.myresume.infrastructure.repository.FormacaoAcademicaRepository;
import com.myresume.infrastructure.repository.IdiomaRepository;
import org.springframework.stereotype.Service;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;


import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.UUID;

@Service
public class CurriculoService {

    private final PessoaRepository pessoaRepo;
    private final ResumoProfissionalRepository resumoRepo;
    private final HabilidadeRepository habilidadeRepo;
    private final ExperienciaRepository experienciaRepo;
    private final FormacaoAcademicaRepository formacaoRepo;
    private final CertificacaoRepository certificacaoRepo;
    private final IdiomaRepository idiomaRepo;

    public CurriculoService(PessoaRepository pessoaRepo,
                            ResumoProfissionalRepository resumoRepo,
                            HabilidadeRepository habilidadeRepo,
                            ExperienciaRepository experienciaRepo,
                            FormacaoAcademicaRepository formacaoRepo,
                            CertificacaoRepository certificacaoRepo,
                            IdiomaRepository idiomaRepo) {
        this.pessoaRepo = pessoaRepo;
        this.resumoRepo = resumoRepo;
        this.habilidadeRepo = habilidadeRepo;
        this.experienciaRepo = experienciaRepo;
        this.formacaoRepo = formacaoRepo;
        this.certificacaoRepo = certificacaoRepo;
        this.idiomaRepo = idiomaRepo;
    }

    public byte[] gerarPdf(UUID pessoaId) throws Exception {
        Pessoa pessoa = pessoaRepo.findById(pessoaId)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);

        document.open();
        document.add(new Paragraph(pessoa.getNome() + " - " + pessoa.getCidade() + "/" + pessoa.getUf()));
        document.add(new Paragraph("Telefone: " + pessoa.getTelefone()));

        // Resumo Profissional
        resumoRepo.findByPessoaId(pessoaId).forEach(resumo ->
                addSection(document, "Resumo Profissional", resumo.getResumo()));

        // Habilidades
        habilidadeRepo.findByPessoaId(pessoaId).forEach(h ->
                addSection(document, "Habilidade (" + h.getTipo() + ")", h.getHabilidade()));

        // Experiências
        experienciaRepo.findByPessoaId(pessoaId).forEach(exp ->
                addSection(document, "Experiência: " + exp.getCargo(),
                        exp.getEmpresa() + " (" + exp.getMesAnoInicio() + " - " + exp.getMesAnoFinal() + ")\n" + exp.getAtividades()));

        // Formação
        formacaoRepo.findByPessoaId(pessoaId).forEach(f ->
                addSection(document, "Formação Acadêmica",
                        f.getNomeInstituicao() + " - " + f.getNivelEscolar() + " (" + f.getMesAnoInicio() + " - " + f.getMesAnoFinal() + ")"));

        // Certificações
        certificacaoRepo.findByPessoaId(pessoaId).forEach(c ->
                addSection(document, "Certificação", c.getTitulo() + " - " + c.getMesAno()));

        // Idiomas
        idiomaRepo.findByPessoaId(pessoaId).forEach(i ->
                addSection(document, "Idioma", i.getIdioma() + " - " + i.getNivel()));

        document.close();
        return out.toByteArray();
    }

    private void addSection(Document doc, String titulo, String conteudo) {
        try {
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(titulo, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
            doc.add(new Paragraph(conteudo));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao adicionar seção", e);
        }
    }
}

