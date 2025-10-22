package br.com.projeta_api.dto;

import lombok.Data;

@Data
public class CobrancasDTO {

    private Long id;
    private Long cicloId;
    private String cliente;
    private String dataEmissao;
    private String valorTotal;
    private String statusCobranca;
}
