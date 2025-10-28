package br.com.projeta_api.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrecosUnitariosDTO {
    private Long id;
    private Long contratoId;
    private String codigo;
    private String categoria;
    private String descricao;
    private String formato;
    private Integer quantidade;
    private BigDecimal precoUnitario;
}
