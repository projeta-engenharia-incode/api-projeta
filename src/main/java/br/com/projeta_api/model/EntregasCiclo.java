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
@Table(name = "entregas_ciclo")
public class EntregasCiclo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "documento_id", nullable = false)
    private Documentos documento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ciclo_id", nullable = false)
    private Ciclo ciclo;

    @Column(name = "data_entrega")
    private LocalDate dataEntrega;

    @Column(name = "percentual_cobrado", precision = 5, scale = 2)
    private BigDecimal percentualCobrado;

    @Column(name = "valor_cobrado", precision = 14, scale = 2)
    private BigDecimal valorCobrado;

    @Column(name = "status_cobranca", length = 40)
    private StatusCobranca statusCobranca;
}
