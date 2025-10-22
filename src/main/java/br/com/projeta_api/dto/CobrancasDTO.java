package br.com.projeta_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CobrancasDTO {

    private Long id;
    private Long cicloId;
    private String cliente;
    private LocalDate dataEmissao;
    private BigDecimal valorTotal;
    private String statusCobranca;
}
