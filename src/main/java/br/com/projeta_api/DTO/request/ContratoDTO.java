package br.com.projeta_api.DTO.request;

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
    private String codigo;
    private String contrato;
    private String subcontrato;
    private String empresa;
    private String gestor;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private BigDecimal valorTotal;
    private Integer revisao;
    private Long preContratoId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
