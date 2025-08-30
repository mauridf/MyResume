package com.myresume.api.controller;

import com.myresume.application.service.CurriculoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/curriculo")
public class CurriculoController {

    private final CurriculoService curriculoService;

    public CurriculoController(CurriculoService curriculoService) {
        this.curriculoService = curriculoService;
    }

    @GetMapping("/{pessoaId}/pdf")
    public ResponseEntity<byte[]> gerarPdf(@PathVariable UUID pessoaId) throws Exception {
        byte[] pdf = curriculoService.gerarPdf(pessoaId);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=curriculo.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}

