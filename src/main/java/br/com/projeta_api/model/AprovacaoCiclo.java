package br.com.projeta_api.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "aprovacoes_cli")
public class AprovacaoCiclo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "documento_id", nullable = false)
    private Documentos documento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ciclo_id", nullable = false)
    private Ciclo ciclo;

    @Column(name = "data_aprovacao")
    private LocalDate dataAprovacao;

    @Column(name = "origem")
    private String origem;

    @Column(name = "autorizado_por", length = 120)
    private String autorizadoPor;

    @Column(name = "status_aprovacao", length = 40)
    private String statusAprovacao;

    @Column(name = "observacoes", columnDefinition = "TEXT")
    private String observacoes;
}
