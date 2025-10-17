package br.com.projeta_api.dto;

import lombok.Data;

@Data
public class ChamadosDTO {

    private long id;
    private String coordenador;
    private Boolean atendido;
    private String nomeProjeto;
    private String codigoCliente;
    private String dataAbertura;
    private String dataAgendamento;
    private String dataVisita;
    private String dataEstimativa;
    private String createdAt;
}
