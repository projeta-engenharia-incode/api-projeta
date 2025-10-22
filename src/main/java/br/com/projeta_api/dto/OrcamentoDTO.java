package br.com.projeta_api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrcamentoDTO {
    private Long id;
    private Long chamadoId;
    private String codigoOrcamento;
    private String statusOrcamento;
    private Long orcamentistaId;
    private String nomeOrcamento;
    private boolean cronograma;
    private String centroDeCusto;
    private String dataEmissao;
    private String dataRevisao;
    private Integer numeroRevisao;
    private String dataAprovacao;
    private Integer diasExecucao;
    private String dataFinalizacao;
    private String numeroSe;
    private String numeroLd;
    private BigDecimal valorOrcado;
    private BigDecimal valorAprovado;
    private BigDecimal valorPrevisto;
    private BigDecimal percentualExecucao;
}
