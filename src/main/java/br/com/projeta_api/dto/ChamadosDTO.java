package br.com.projeta_api.dto;

import br.com.projeta_api.model.enums.StatusChamados;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChamadosDTO {

    private Long id;
    private String coordenador;
    private Boolean atendido;
    private StatusChamados status;
    private String nomeProjeto;
    private String codigoCliente;
    private Long contratoId;
    private LocalDate dataAbertura;
    private LocalDate dataAgendamento;
    private LocalDate dataVisita;
    private LocalDateTime dataEstimativa;
    private LocalDateTime createdAt;
}
