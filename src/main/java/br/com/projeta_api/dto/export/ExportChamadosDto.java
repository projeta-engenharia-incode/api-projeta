package br.com.projeta_api.dto.export;


import br.com.projeta_api.model.Chamados;
import br.com.projeta_api.model.Contrato;
import br.com.projeta_api.model.enums.StatusChamados;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExportChamadosDto {

    private Long id;
    private String coordenador;
    private Boolean atendido;
    private StatusChamados status;
    private String nomeProjeto;
    private String codigoCliente;
    private String nomeContrato;
    private LocalDate dataAbertura;
    private LocalDate dataAgendamento;
    private LocalDate dataVisita;
    private LocalDateTime dataEstimativa;
    private LocalDateTime createdAt;

    public ExportChamadosDto(Chamados chamados){
        this.id = chamados.getId();
        this.coordenador = chamados.getCoordenador();
        this.atendido = chamados.getAtendido();
        this.status = chamados.getStatus();
        this.nomeProjeto = chamados.getNomeProjeto();
        this.codigoCliente = chamados.getCodigoCliente();
        this.nomeContrato = chamados.getContrato().getContrato();
        this.dataAbertura = chamados.getDataAbertura();
        this.dataAgendamento = chamados.getDataAgendamento();
        this.dataVisita = chamados.getDataVisita();
        this.dataEstimativa = chamados.getDataEstimativa();
    }
}
