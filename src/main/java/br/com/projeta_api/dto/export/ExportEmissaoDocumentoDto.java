package br.com.projeta_api.dto.export;


import br.com.projeta_api.model.EmissoesDocumento;
import br.com.projeta_api.model.enums.StatusEmissoesDocumentos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExportEmissaoDocumentoDto {

    private Long id;
    private String nomeDocumento;
    private String fase;
    private String tipoRevisao;
    private String tipoEmissao;
    private LocalDateTime dataEmissao;
    private LocalDateTime dataEntrega;
    private StatusEmissoesDocumentos status;
    private LocalDateTime dataRetorno;
    private Double percRevisao;
    private Double equivalenteRevisado;
    private Integer ordemEmissao;
    private Boolean ultimaEmissao;

    public ExportEmissaoDocumentoDto(EmissoesDocumento emissoesDocumento) {
        this.id = emissoesDocumento.getId();
        this.nomeDocumento = emissoesDocumento.getDocumentos().getCodigoDoc();
        this.fase = emissoesDocumento.getFase();
        this.tipoRevisao = emissoesDocumento.getTipo_revisao();
        this.tipoEmissao = emissoesDocumento.getTipo_emissao();
        this.dataEmissao = emissoesDocumento.getData_emissao();
        this.dataEntrega = emissoesDocumento.getData_entrega();
        this.status = emissoesDocumento.getStatus_retorno();
        this.dataRetorno = emissoesDocumento.getData_retorno();
        this.percRevisao = emissoesDocumento.getPerc_revisao();
        this.equivalenteRevisado = emissoesDocumento.getEquivalente_revisado();
        this.ordemEmissao = emissoesDocumento.getOrdem_emissao();
        this.ultimaEmissao = emissoesDocumento.getUltima_emissao();

   }
}
