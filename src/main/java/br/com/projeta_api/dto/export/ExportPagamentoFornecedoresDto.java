package br.com.projeta_api.dto.export;


import br.com.projeta_api.model.PagamentosFornecedores;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExportPagamentoFornecedoresDto {


    private Long id;
    private String nomeFornecedor;
    private String nomeDocumento;
    private BigDecimal percentualPago;
    private BigDecimal valorPago;
    private LocalDateTime dataPagamento;

    public ExportPagamentoFornecedoresDto(PagamentosFornecedores  pagamentosFornecedores){
        this.id = pagamentosFornecedores.getId();
        this.nomeFornecedor = pagamentosFornecedores.getFornecedores().getNome();
        this.nomeDocumento = pagamentosFornecedores.getDocumentos().getCodigoDoc();
        this.percentualPago = pagamentosFornecedores.getPercentualPago();
        this.valorPago = pagamentosFornecedores.getValorPago();
        this.dataPagamento = pagamentosFornecedores.getDataPagamento();
    }
}
