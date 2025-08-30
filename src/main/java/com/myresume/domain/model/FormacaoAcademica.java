package com.myresume.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "formacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormacaoAcademica {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "A instituição é obrigatória")
    private String nomeInstituicao;
    @NotBlank(message = "O nível escolar é obrigatório")
    private String nivelEscolar;
    @Pattern(regexp = "(0[1-9]|1[0-2])/\\d{4}", message = "Data de início deve estar no formato MM/AAAA")
    private String mesAnoInicio;
    @Pattern(regexp = "(0[1-9]|1[0-2])/\\d{4}", message = "Data de final deve estar no formato MM/AAAA")
    private String mesAnoFinal;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;
}
