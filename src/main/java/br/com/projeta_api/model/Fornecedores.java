package br.com.projeta_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fornecedores")
public class Fornecedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "contrato_id", length = 11)
    private Integer contrato_id;
    @Column(name = "nome", length = 120)
    private String nome;
    @Column(name = "tipo", length = 60)
    private String tipo;
}
