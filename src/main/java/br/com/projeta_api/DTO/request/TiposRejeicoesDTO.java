package br.com.projeta_api.DTO.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TiposRejeicoesDTO {
    private Long id;
    private String codigo;
    private String descricao;
    private List<Long> rejeicoesIds;
}
