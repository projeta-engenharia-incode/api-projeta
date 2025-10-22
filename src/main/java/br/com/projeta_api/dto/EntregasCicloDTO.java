package br.com.projeta_api.dto;

import lombok.Data;

@Data
public class EntregasCicloDTO {

    private Long id;
    private Long documentoId;
    private Long cicloId;
    private String dataEntrega;
    private String percentualCobrado;
    private String valorCobrado;
    private String statusCobranca;
}
