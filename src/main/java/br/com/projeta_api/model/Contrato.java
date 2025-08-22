package br.com.projeta_api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "contratos")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", length = 50, nullable = false, unique = true)
    private String codigo;

    @Column(name = "contrato", length = 120, nullable = false)
    private String contrato;

    @Column(name = "subcontrato", length = 120)
    private String subcontrato;

    @Column(name = "empresa", length = 120, nullable = false)
    private String empresa;

    @Column(name = "gestor", length = 120, nullable = false)
    private String gestor;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_fim", nullable = false)
    private LocalDate dataFim;

    @Column(name = "valor_total", precision = 14, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "revisao")
    private Integer revisao = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pre_contrato_id")
    private PreContratos preContrato;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Preencher automaticamente as datas
    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
