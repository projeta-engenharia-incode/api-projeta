package br.com.projeta_api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContratoDTO {

    private Long id;
    private String codigo;
    private String contrato;
    private String subcontrato;
    private String empresa;
    private String gestor;
    private String dataInicio;
    private String dataFim;
    private String valorTotal;
    private Integer revisao;
    private Long preContratoId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
