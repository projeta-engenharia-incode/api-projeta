package br.com.projeta_api.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmissaoDocumentoDTO {
    private Long id;
    private Integer documento_id;
    private String fase;
    private String tipo_revisao;
    private String tipo_emissao;
    private LocalDateTime data_emissao;
    private LocalDateTime data_entrega;
    private String status_retorno;
    private LocalDateTime data_retorno;
    private Double perc_revisao;
    private Double equivalente_revisado;
    private Integer ordem_emissao;
    private Boolean ultima_emissao;
}
