package br.com.projeta_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "precos_unitarios")
public class PrecosUnitarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "contrato_id", length = 20)
    private Integer contratoId;
    @Column(name = "categoria", length = 120)
    private String contrato;
    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;
    @Column(name = "formato", length = 20)
    private String formato;
    @Column(name = "quantidade", length = 11)
    private Integer quantidade;
    @Column(name = "preco_unitario", precision = 10, scale = 2)
    private Double precoUnitario;
}
