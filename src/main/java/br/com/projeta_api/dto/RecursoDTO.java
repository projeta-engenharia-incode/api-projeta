package br.com.projeta_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecursoDTO {

    private Long id;
    private String nome;
    private String tipo;
    private Integer quantidadeTotal;
}
