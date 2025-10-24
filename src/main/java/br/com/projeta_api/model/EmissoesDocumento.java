package br.com.projeta_api.model;

import br.com.projeta_api.model.enums.StatusEmissoesDocumentos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emissoes_documento")
public class EmissoesDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "documento_id")
    private Documentos documentos;
    @Column(name = "fase", length = 20)
    private String fase;
    @Column(name = "tipo_revisao", length = 10)
    private String tipo_revisao;
    @Column(name = "tipo_emissao", length = 10)
    private String tipo_emissao;
    @Column(name = "data_emissao")
    private LocalDateTime data_emissao;
    @Column(name = "data_entrega")
    private LocalDateTime data_entrega;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_retorno", length = 40)
    private StatusEmissoesDocumentos status_retorno;
    @Column(name = "data_retorno")
    private LocalDateTime data_retorno;
    @Column(name = "perc_revisao")
    private Double perc_revisao;
    @Column(name = "equivalente_revisado")
    private Double equivalente_revisado;
    @Column(name = "ordem_emissao", length = 11)
    private Integer ordem_emissao;
    @Column(name = "ultima_emissao")
    private Boolean ultima_emissao;

}
