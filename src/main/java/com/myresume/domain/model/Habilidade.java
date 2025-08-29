package com.myresume.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "habilidades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Habilidade {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String tipo; // Backend, Frontend, DB, etc.

    @Column(nullable = false)
    private String habilidade;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;
}

