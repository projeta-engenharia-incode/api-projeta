package br.com.projeta_api.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PreContratoDTO {

    private long id;
    private Long chamadoId;
    private String titulo;
    private String descricao;
    private String status;
    private BigDecimal valorEstimado;
    private LocalDate dataProposta;
    private LocalDate dataValidade;
    private LocalDateTime createdAt;
}
