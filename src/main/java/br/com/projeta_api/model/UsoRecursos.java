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
    @Column(name = "recurso_id", length = 20)
    private Integer recursoId;
    @Column(name = "documento_id", length = 20)
    private Integer documentoId;
    @Column(name = "quantidade_usada", length = 11)
    private Integer quantidadeUsada;
    @Column(name = "data_uso")
    private LocalDateTime dataUso;
}
