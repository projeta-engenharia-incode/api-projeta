package br.com.projeta_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ciclos")
public class Ciclo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome", length = 100, nullable = false)
    private String nome;

    @Column (name = "created_at", updatable = false)
    private java.time.LocalDateTime createdAt;

    @Column (name = "updated_at")
    private java.time.LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = java.time.LocalDateTime.now();
        updatedAt = java.time.LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = java.time.LocalDateTime.now();
    }
}
