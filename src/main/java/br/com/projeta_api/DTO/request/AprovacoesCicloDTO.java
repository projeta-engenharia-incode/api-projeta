package br.com.projeta_api.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AprovacoesCicloDTO {
    private Long id;
    private Long documentoId;
    private Long cicloId;
    private LocalDateTime dataAprovacao;
    private String autorizadoPor;
    private String statusAprovacao;
    private String observacoes;

}
