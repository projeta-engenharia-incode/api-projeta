package br.com.projeta_api.dto.export;

import br.com.projeta_api.model.Orcamento;
import br.com.projeta_api.model.enums.StatusOrcamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExportOrcamentoDto {


    private Long id;
    private String nomeChamado;
    private String codigoOrcamento;
    private StatusOrcamento statusOrcamento;
    private String orcamentista;
    private String nomeOrcamento;
    private boolean cronograma;
    private String centroDeCusto;
    private LocalDate dataEmissao;
    private LocalDate dataRevisao;
    private Integer numeroRevisao;
    private LocalDate dataAprovacao;
    private Integer diasExecucao;
    private LocalDate dataFinalizacao;
    private String numeroSe;
    private String numeroLd;
    private BigDecimal valorOrcado;
    private BigDecimal valorAprovado;
    private BigDecimal valorPrevisto;
    private BigDecimal percentualExecucao;

    public ExportOrcamentoDto(Orcamento orcamento) {
        this.id = orcamento.getId();
        this.nomeChamado = orcamento.getChamados().getNomeProjeto();
        this.codigoOrcamento = orcamento.getCodigoOrcamento();
        this.statusOrcamento = orcamento.getStatusOrcamento();
        this.orcamentista = orcamento.getOrcamentista();
        this.nomeOrcamento = orcamento.getNomeOrcamento();
        this.cronograma = orcamento.isCronograma();
        this.centroDeCusto = orcamento.getCentroDeCusto();
        this.dataEmissao = orcamento.getDataEmissao();
        this.dataRevisao = orcamento.getDataRevisao();
        this.numeroRevisao = orcamento.getNumeroRevisao();
        this.dataAprovacao = orcamento.getDataAprovacao();
        this.diasExecucao = orcamento.getDiasExecucao();
        this.dataFinalizacao = orcamento.getDataFinalizacao();
        this.numeroSe = orcamento.getNumeroSe();
        this.numeroLd = orcamento.getNumeroLd();
        this.valorOrcado = orcamento.getValorOrcado();
        this.valorAprovado = orcamento.getValorAprovado();
        this.valorPrevisto = orcamento.getValorPrevisto();
        this.percentualExecucao = orcamento.getPercentualExecucao();
    }
}
