package br.com.projeta_api.DTO.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AprovacoesCicloDTO {
    private Long id;
    @Column(name = "documento_id", length = 11)
    private Integer documento_id;
    @Column(name = "ciclo_id", length = 11)
    private Integer ciclo_id;
    @Column(name = "data_aprovacao")
    private LocalDateTime data_aprovacao;
    @Column(name = "autorizado_pro", length = 120)
    private String autorizado_por;
    @Column(name = "status_aprovacao", length = 40)
    private String status_aprovacao;
    @Column(name = "observacoes", columnDefinition = "TEXT")
    private String observacoes;

}
