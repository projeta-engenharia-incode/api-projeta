package br.com.projeta_api.model;

import br.com.projeta_api.model.enums.StatusChamados;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "chamados")
public class Chamados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coordenador", length = 120)
    private String coordenador;

    @Column(name = "atendido", nullable = false)
    private Boolean atendido;

    @Column(name = "nome_projeto", nullable = false)
    private String nomeProjeto;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusChamados status;

    @Column(name = "codigo_cliente", length = 50)
    private String codigoCliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;

    @Column(name = "data_abertura")
    private LocalDate dataAbertura;

    @Column(name = "data_agendamento")
    private LocalDate dataAgendamento;

    @Column(name = "data_visita")
    private LocalDate dataVisita;

    @OneToMany(mappedBy = "chamado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PreContrato> preContratos = new ArrayList<>();


    @Column(name = "data_estimativa")
    private LocalDateTime dataEstimativa;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

}