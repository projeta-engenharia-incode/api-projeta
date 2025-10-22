package br.com.projeta_api.dto;

import lombok.Data;

@Data
public class ResponsaveisDocumentoDTO {

    private Long id;
    private Long documentoId;
    private String nome;
    private String funcao;
    private Long usuarioId;
}
