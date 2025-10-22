package br.com.projeta_api.DTO.request;

import br.com.projeta_api.model.PreContrato;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContratoDTO {
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
    private Integer revisao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pre_contrato_id")
    private PreContrato preContrato;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
