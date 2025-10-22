package br.com.projeta_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "uso_recursos")
public class UsoRecursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "recurso_id", nullable = false)
    private Recurso recurso;
    @ManyToOne
    @JoinColumn(name = "documento_id", nullable = false)
    private Documentos documentos;
    @Column(name = "quantidade_usada", length = 11)
    private Integer quantidadeUsada;
    @Column(name = "data_uso")
    private LocalDateTime dataUso;
}
