package br.com.projeta_api.dto.export;

import br.com.projeta_api.model.MedicoesDocumentos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExportMedicoesDocumentos {

    private Long id;
    private String nomeDocumento;
    private String nomeCiclo;
    private String numeroBoletim;
    private String revisaoBoletim;
    private Integer quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorMedido;
    private BigDecimal valorTotal;
    private BigDecimal percentualRevisao;
    private LocalDateTime createdAt;

    public ExportMedicoesDocumentos(MedicoesDocumentos  medicoesDocumentos) {
        this.id = medicoesDocumentos.getId();
        this.nomeDocumento = medicoesDocumentos.getDocumento().getCodigoDoc();
        this.nomeCiclo = medicoesDocumentos.getCiclo().getNome();
        this.numeroBoletim = medicoesDocumentos.getNumeroBoletim();
        this.revisaoBoletim = medicoesDocumentos.getRevisaoBoletim();
        this.quantidade = medicoesDocumentos.getQuantidade();
        this.valorUnitario = medicoesDocumentos.getValorUnitario();
        this.valorMedido = medicoesDocumentos.getValorMedido();
        this.valorTotal = medicoesDocumentos.getValorTotal();
        this.percentualRevisao = medicoesDocumentos.getPercentualRevisao();
        this.createdAt = medicoesDocumentos.getCreatedAt();


    }
}
