package com.myresume.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "experiencia_habilidades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExperienciaHabilidade {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "habilidade_id", nullable = false)
    private Habilidade habilidade;

    @ManyToOne
    @JoinColumn(name = "experiencia_id", nullable = false)
    private Experiencia experiencia;
}

