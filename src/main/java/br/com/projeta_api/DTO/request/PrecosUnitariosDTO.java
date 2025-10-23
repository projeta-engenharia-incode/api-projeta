package br.com.projeta_api.DTO.request;

import br.com.projeta_api.model.Contrato;
import jakarta.persistence.Column;
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
    private String descricao;
    private String formato;
    private Integer quantidade;
    private BigDecimal precoUnitario;
}
