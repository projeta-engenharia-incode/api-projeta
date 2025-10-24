package br.com.projeta_api.model;

import br.com.projeta_api.model.enums.StatusOrcamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "orcamentos")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chamado_id", nullable = false)
    private Chamados chamados;

    @Column(name = "codigo_orcamento", length = 60)
    private String codigoOrcamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_orcamento", length = 40)
    private StatusOrcamento statusOrcamento;

    private String orcamentista;

    @Column(name = "nome_orcamento", columnDefinition = "TEXT")
    private String nomeOrcamento;

    @Column
    private boolean cronograma;

    @Column(name = "centro_de_custo", length = 60)
    private String centroDeCusto;

    @Column(name = "data_emissao")
    private LocalDate dataEmissao;

    @Column(name = "data_revisao")
    private LocalDate dataRevisao;

    @Column(name = "numero_revisao" )
    private Integer numeroRevisao;

    @Column(name = "data_aprovacao")
    private LocalDate dataAprovacao;

    @Column(name = "dias_execucao")
    private Integer diasExecucao;

    @Column(name = "data_finalizacao")
    private LocalDate dataFinalizacao;

    @Column(name = "numero_se", length = 60)
    private String numeroSe;

    @Column(name = "numero_ld", length = 60)
    private String numeroLd;

    @Column(name = "valor_orcado", precision = 14, scale = 2)
    private BigDecimal valorOrcado;

    @Column(name = "valor_aprovado", precision = 14, scale = 2)
    private BigDecimal valorAprovado;

    @Column(name = "valor_previsto", precision = 14, scale = 2)
    private BigDecimal valorPrevisto;

    @Column(name = "percentual_execucao", precision = 5, scale = 2)
    private BigDecimal percentualExecucao;
}
