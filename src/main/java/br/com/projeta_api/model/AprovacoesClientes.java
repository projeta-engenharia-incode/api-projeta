package br.com.projeta_api.model;

import br.com.projeta_api.model.enums.StatusAprovacoesCiclo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aprovacoes_ciclo")
public class AprovacoesClientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "documento_id", nullable = false)
    private Documentos documentos;
    @ManyToOne
    @JoinColumn(name = "ciclo_id", nullable = false)
    private Ciclo ciclo;
    @Column(name = "data_aprovacao")
    private LocalDateTime data_aprovacao;

    @Column(name = "autorizado_por", length = 120)
    private String autorizado_por;

    @Column(name = "origem")
    private String origem;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_aprovacao", length = 40)
    private StatusAprovacoesCiclo status_aprovacao;
    @Column(name = "observacoes", columnDefinition = "TEXT")
    private String observacoes;

}
