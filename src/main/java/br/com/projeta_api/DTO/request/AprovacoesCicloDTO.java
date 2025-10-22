package br.com.projeta_api.DTO.request;

import br.com.projeta_api.model.Ciclo;
import br.com.projeta_api.model.Documentos;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AprovacoesCicloDTO {
    private Long id;
    @ManyToOne
    @JoinColumn(name = "documento_id", nullable = false)
    private Documentos documento;
    @ManyToOne
    @JoinColumn(name = "ciclo_id", nullable = false)
    private Ciclo ciclo;
    @Column(name = "data_aprovacao")
    private LocalDateTime dataAprovacao;
    @Column(name = "autorizado_pro", length = 120)
    private String autorizadoPor;
    @Column(name = "status_aprovacao", length = 40)
    private String statusAprovacao;
    @Column(name = "observacoes", columnDefinition = "TEXT")
    private String observacoes;

}
