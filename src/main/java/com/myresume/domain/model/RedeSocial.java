package com.myresume.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "redes_sociais")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RedeSocial {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String redeSocial; // LinkedIn, GitHub, etc.

    @Column(nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;
}
