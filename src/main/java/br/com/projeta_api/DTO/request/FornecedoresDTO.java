package br.com.projeta_api.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FornecedoresDTO {

    private Long id;
    private Long contratId;
    private String nome;
    private String tipo;
}
