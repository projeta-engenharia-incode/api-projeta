package br.com.projeta_api.DTO.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevisoesDocDTO {
    private Long id;
    @Column(name = "revisao",length = 5, nullable = false)
    private String revisao;
    @Column(name = "responsavel", length = 120, nullable = false)
    private String responsavel;
    @Column(name = "data_envio")
    private LocalDateTime dataEnvio;
    @Column(name = "data_resposta_cli")
    private LocalDateTime dataRespostaCiclo;
    @Column(name = "status_revisao", length = 40)
    private String statusRevisao;
    @Column(name = "observacoes", columnDefinition = "TEXT")
    private String observacoes;
}
