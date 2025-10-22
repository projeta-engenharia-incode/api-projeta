package br.com.projeta_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsaveisDocumentoDTO {

    private Long id;
    private Long documentoId;
    private String nome;
    private String funcao;
    private Long usuarioId;
}
