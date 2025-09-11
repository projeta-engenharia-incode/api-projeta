package br.com.projeta_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rejeicoes_revisao")
public class RejeicoesRevisao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tipos_rejeicoes_id", nullable = false)
    private TiposRejeicoes tiposRejeicoes;

    @ManyToOne
    @JoinColumn(name = "revisao_id", nullable = false)
    private RevisoesDoc revisoesDoc;
}