package br.com.projeta_api.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TiposRejeicoesDTO {
    private Long id;
    private String codigo;
    private String descricao;
    //private List<Long> rejeicoesIds;
}
