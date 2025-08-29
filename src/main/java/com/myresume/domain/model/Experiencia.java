package com.myresume.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "experiencias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Experiencia {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String empresa;

    @Column(nullable = false)
    private String cargo;

    private String mesAnoInicio;
    private String mesAnoFinal;

    @Column(columnDefinition = "TEXT")
    private String atividades;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;
}

