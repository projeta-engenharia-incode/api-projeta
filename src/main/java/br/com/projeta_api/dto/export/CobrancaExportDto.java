package br.com.projeta_api.dto.export;


import br.com.projeta_api.model.Cobrancas;
import br.com.projeta_api.model.enums.StatusCobranca;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CobrancaExportDto {

    private Long id;
    private Long cicloId;
    private BigDecimal valor;
    private LocalDate data;
    private StatusCobranca status;

    public CobrancaExportDto(Cobrancas cobranca) {
        this.id = cobranca.getId();
        this.cicloId = cobranca.getCiclo() != null ? cobranca.getCiclo().getId() : null;
        this.valor = cobranca.getValorTotal();
        this.data = cobranca.getDataEmissao();
        this.status = cobranca.getStatusCobranca();
    }
}
