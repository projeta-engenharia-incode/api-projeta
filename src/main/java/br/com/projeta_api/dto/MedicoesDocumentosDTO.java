package br.com.projeta_api.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MedicoesDocumentosDTO {

    private Long id;
    private Long documentoId;
    private Long cicloId;
    private String numeroBoletim;
    private String revisaoBoletim;
    private Integer quantidade;
    private String valorUnitario;
    private String valorMedido;
    private String valorTotal;
    private String percentualRevisao;
    private LocalDate cratedAt;
}
