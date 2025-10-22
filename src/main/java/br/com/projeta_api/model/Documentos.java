package br.com.projeta_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "documentos")
public class Documentos {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
        @ManyToOne
        @JoinColumn(name = "projeto_id", nullable = false)
        private Projeto projetoId;
        @ManyToOne
        @JoinColumn(name = "ciclo_id", nullable = false)
        private Ciclo cicloId;
        @Column(name = "codigo_doc", nullable = false, length = 60)
        private String codigoDoc;
        @Column(name = "titulo_secundario", columnDefinition = "text")
        private String tituloSecundario;
        @Column(length = 60)
        private String tipo;
        @Column(length = 10)
        private String formato;
        @Column(length = 120)
        private String categoria;
        @Column(columnDefinition = "text")
        private String descricao;
        @Column(name = "status_documento", length = 40)
        private String statusDocumento;
        @Column(length = 40)
        private String etapa;
        @Column(length = 120)
        private String responsavel;
        @Column(length = 120)
        private String auxiliar;
        @Column(name = "num_projeta", length = 80)
        private String numProjeta;
        @Column(name = "num_cliente", length = 80)
        private String numCliente;
        @Column(name = "num_se", length = 80)
        private String numSe;
        @Column(columnDefinition = "text")
        private String datas;
        @Column(name = "qtd_prevista")
        private Integer qtdPrevista;
        @Column(precision = 6, scale = 2)
        private Double multiplicador;
        @Column(name = "item_qqf", length = 30)
        private String itemQqf;
        @Column(name = "equivalente_previsto", precision = 10, scale = 2)
        private Double equivalentePrevisto;
        @Column(name = "equivalente_entregue", precision = 10, scale = 2)
        private Double equivalenteEntregue;
        @Column(name = "valor_unitario", precision = 14, scale = 2)
        private Double valorUnitario;
        @Column(name = "valor_previsto", precision = 14, scale = 2)
        private Double valorPrevisto;
        @Column(name = "valor_entregue", precision = 14, scale = 2)
        private Double valorEntregue;
        @Column(name = "valor_reajustado", precision = 14, scale = 2)
        private Double valorReajustado;
        @Column(name = "percentual_execucao", precision = 5, scale = 2)
        private Double percentualExecucao;
        @Column(columnDefinition = "text")
        private String observacao;
        @Column(name = "created_at")
        private LocalDateTime createdAt;
        @Column(name = "updated_at")
        private LocalDateTime updatedAt;

        @OneToMany(mappedBy = "documentos", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<UsoRecursos> usoRecursos = new ArrayList<>();

        @OneToMany(mappedBy = "documentos",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<PagamentosFornecedores> pagamentosFornecedores = new ArrayList<>();

        @OneToMany(mappedBy = "documentos", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<AprovacoesCiclo> aprovacoesCiclos = new ArrayList<>();

}
