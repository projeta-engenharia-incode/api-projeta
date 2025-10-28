package br.com.projeta_api.dto.export;


import br.com.projeta_api.model.EntregasCiclo;
import br.com.projeta_api.model.enums.StatusEntregaCiclo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExportEntregasCicloDto {

    private Long id;
    private String nomeDocumento;
    private String nomeCiclo;
    private LocalDate dataEntrega;
    private BigDecimal percentualCobrado;
    private BigDecimal valorCobrado;
    private StatusEntregaCiclo status;

    public ExportEntregasCicloDto(EntregasCiclo entregasCiclo){
        this.id = entregasCiclo.getId();
        this.nomeDocumento = entregasCiclo.getDocumento().getCodigoDoc();
        this.nomeCiclo = entregasCiclo.getCiclo().getNome();
        this.dataEntrega = entregasCiclo.getDataEntrega();
        this.percentualCobrado = entregasCiclo.getPercentualCobrado();
        this.valorCobrado = entregasCiclo.getValorCobrado();
        this.status = entregasCiclo.getStatus();

    }
}
