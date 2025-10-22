package br.com.projeta_api.model;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "chamados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chamados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "coordenador", length = 120)
    private String coordenador;

    @Column(name = "atendido", nullable = false)
    private Boolean atendido;

    @Column(name = "nome_projeto", nullable = false)
    private String nomeProjeto;

    @Column(name = "codigo_cliente", length = 50)
    private String codigoCliente;

    @Column(name = "data_abertura")
    private LocalDate dataAbertura;

    @Column(name = "data_agendamento")
    private LocalDate dataAgendamento;

    @Column(name = "data_visita")
    private LocalDate dataVisita;

    @Column(name = "data_estimativa")
    private LocalDateTime dataEstimativa;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;



    //--------------------------Getters e Setters---------------------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public Boolean getAtendido() {
        return atendido;
    }

    public void setAtendido(Boolean atendido) {
        this.atendido = atendido;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public LocalDate getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(LocalDate dataVisita) {
        this.dataVisita = dataVisita;
    }

    public LocalDateTime getDataEstimativa() {
        return dataEstimativa;
    }

    public void setDataEstimativa(LocalDateTime dataEstimativa) {
        this.dataEstimativa = dataEstimativa;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}