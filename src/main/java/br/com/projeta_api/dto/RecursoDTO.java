package br.com.projeta_api.dto;

import lombok.Data;

@Data
public class RecursoDTO {

    private Long id;
    private String nome;
    private String tipo;
    private Integer quantidadeTotal;
}
