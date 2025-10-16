package br.com.projeta_api.DTO.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmissaoDocumentoDTO {
    @Column(name = "documento_id", length = 11)
    private Integer documento_id;
    @Column(name = "fase", length = 20)
    private String fase;
    @Column(name = "tipo_revisao", length = 10)
    private String tipo_revisao;
    @Column(name = "tipo_emissao", length = 10)
    private String tipo_emissao;
    @Column(name = "data_emissao")
    private LocalDateTime data_emissao;
    @Column(name = "data_entrega")
    private LocalDateTime data_entrega;
    @Column(name = "status_retorno", length = 40)
    private String status_retorno;
    @Column(name = "data_retorno")
    private LocalDateTime data_retorno;
    @Column(name = "perc_revisao")
    private Double perc_revisao;
    @Column(name = "equivalente_revisado")
    private Double equivalente_revisado;
    @Column(name = "ordem_emissao", length = 11)
    private Integer ordem_emissao;
    @Column(name = "ultima_emissao")
    private Boolean ultima_emissao;
}
