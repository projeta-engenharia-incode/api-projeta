package br.com.projeta_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "revisoes_doc")
public class RevisoesDoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "revisao",length = 5, nullable = false)
    private String revisao;
    @Column(name = "responsavel", length = 120, nullable = false)
    private String responsavel;
    @Column(name = "data_envio")
    private LocalDateTime dataEnvio;
    @Column(name = "data_resposta_cli")
    private LocalDateTime dataRespostaCli;
    @Column(name = "status_revisao", length = 40)
    private String statusRevisao;
    @Column(name = "observacoes", columnDefinition = "TEXT")
    private String observacoes;

    @OneToMany(mappedBy = "revisoesDoc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RejeicoesRevisao> rejeicoes;

}
