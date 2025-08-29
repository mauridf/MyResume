package com.myresume.domain.model;

import jakarta.persistence.*;
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

    private String nomeInstituicao;
    private String nivelEscolar;
    private String mesAnoInicio;
    private String mesAnoFinal;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;
}
