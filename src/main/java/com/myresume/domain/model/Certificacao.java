package com.myresume.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "certificacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Certificacao {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "Título da certificação é obrigatório")
    private String titulo;
    @Pattern(regexp = "(0[1-9]|1[0-2])/\\d{4}", message = "Mês/ano deve estar no formato MM/AAAA")
    private String mesAno;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;
}
