package br.com.projeta_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrcamentoDTO {
    private Long id;
    private Long chamadoId;
    private String codigoOrcamento;
    private String statusOrcamento;
    private Long orcamentistaId;
    private String nomeOrcamento;
    private boolean cronograma;
    private String centroDeCusto;
    private LocalDate dataEmissao;
    private LocalDate dataRevisao;
    private Integer numeroRevisao;
    private LocalDate dataAprovacao;
    private Integer diasExecucao;
    private LocalDate dataFinalizacao;
    private String numeroSe;
    private String numeroLd;
    private BigDecimal valorOrcado;
    private BigDecimal valorAprovado;
    private BigDecimal valorPrevisto;
    private BigDecimal percentualExecucao;
}
