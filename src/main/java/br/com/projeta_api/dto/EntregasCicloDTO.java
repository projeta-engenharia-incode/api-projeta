package br.com.projeta_api.dto;

import br.com.projeta_api.model.StatusCobranca;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntregasCicloDTO {

    private Long id;
    private Long documentoId;
    private Long cicloId;
    private LocalDate dataEntrega;
    private BigDecimal percentualCobrado;
    private BigDecimal valorCobrado;
    private StatusCobranca statusCobranca;
}
