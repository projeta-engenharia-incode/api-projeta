package br.com.projeta_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoesDocumentosDTO {

    private Long id;
    private Long documentoId;
    private Long cicloId;
    private String numeroBoletim;
    private String revisaoBoletim;
    private Integer quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorMedido;
    private BigDecimal valorTotal;
    private BigDecimal percentualRevisao;
    private LocalDateTime createdAt;
}
