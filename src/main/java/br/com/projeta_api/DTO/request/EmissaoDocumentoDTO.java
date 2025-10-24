package br.com.projeta_api.DTO.request;

import br.com.projeta_api.model.enums.StatusEmissoesDocumentos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmissaoDocumentoDTO {
    private Long id;
    private Long documentoId;
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
}
