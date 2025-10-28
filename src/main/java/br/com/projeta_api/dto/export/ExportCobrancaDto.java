package br.com.projeta_api.dto.export;

import br.com.projeta_api.model.Cobrancas;
import br.com.projeta_api.model.enums.StatusCobranca;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExportCobrancaDto {

    private Long id;
    private String cicloName;
    private String cliente;
    private LocalDate dataEmissao;
    private StatusCobranca status;
    private BigDecimal valorTotal;
    private StatusCobranca statusCobranca;


    public ExportCobrancaDto(Cobrancas cobrancas){
        this.id = cobrancas.getId();
        this.cicloName = cobrancas.getCiclo().getNome();
        this.cliente = cobrancas.getCliente();
        this.dataEmissao = cobrancas.getDataEmissao();
        this.status = cobrancas.getStatusCobranca();
        this.valorTotal = cobrancas.getValorTotal();
        this.statusCobranca = cobrancas.getStatusCobranca();

    }
}
