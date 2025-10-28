package br.com.projeta_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
    @ManyToOne
    @JoinColumn(name = "contrato_id",nullable = false)
    private Contrato contrato;
    @Column(name = "categoria", length = 120)
    private String categoria;

    @Column(name = "codigo")
    private String codigo;
    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;
    @Column(name = "formato", length = 20)
    private String formato;
    @Column(name = "quantidade", length = 11)
    private Integer quantidade;
    @Column(name = "preco_unitario", precision = 10, scale = 2)
    private BigDecimal precoUnitario;

    @Column(name = "percentual_reajuste", precision = 5, scale = 2)
    private BigDecimal percentualReajuste; // Ex: 5.00 = 5%

    @Column(name = "valor_reajuste", precision = 10, scale = 2)
    private BigDecimal valorReajuste; // Valor calculado do acréscimo

    @Column(name = "preco_ajustado", precision = 10, scale = 2)
    private BigDecimal precoAjustado; // Novo preço com reajuste

    @Column(name = "valor_total", precision = 10, scale = 2)
    private BigDecimal valorTotal; //
}
