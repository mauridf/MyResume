package com.myresume.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "idiomas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Idioma {

    @Id
    @GeneratedValue
    private UUID id;

    private String idioma;
    private String nivel; // Básico, Intermediário, Avançado, Fluente

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;
}

