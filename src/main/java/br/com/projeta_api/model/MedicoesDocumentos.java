package br.com.projeta_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "medicoes_documentos")
@NoArgsConstructor
@AllArgsConstructor
public class MedicoesDocumentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "documento_id", nullable = false, referencedColumnName = "id")
    private Documentos documento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ciclo_id", nullable = false, referencedColumnName = "id")
    private Ciclo ciclo;

    @Column(name = "numero_boletim", length = 40)
    private String numeroBoletim;

    @Column(name = "revisao_boletim", length = 10)
    private String revisaoBoletim;

    @Column
    private Integer quantidade;

    @Column(name = "valor_unitario", precision = 14, scale = 2)
    private BigDecimal valorUnitario;

    @Column(name = "valor_medido", precision = 14, scale = 2)
    private BigDecimal valorMedido;

    @Column(name = "valor_total", precision = 14, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "percentual_revisao", precision = 5, scale = 2)
    private BigDecimal percentualRevisao;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
