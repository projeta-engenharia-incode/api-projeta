package br.com.projeta_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "cobrancas")
public class Cobrancas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ciclo_id", nullable = false)
    private Ciclo ciclo;

    @Column(name = "cliente", length = 120)
    private String cliente;

    @Column(name = "data_emissao")
    private LocalDate dataEmissao;

    @Column(name = "valor_total", precision = 14, scale = 2)
    private BigDecimal valorTotal;


    @Enumerated(EnumType.STRING)
    @Column(name = "status_cobranca", length = 40)
    private StatusCobranca statusCobranca;
}
