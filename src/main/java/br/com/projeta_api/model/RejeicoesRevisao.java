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
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "tipos_rejeicoes_id")
    private TiposRejeicoes tiposRejeicoes;
    @ManyToOne
    @JoinColumn(name = "id_revisoes")
    private RevisoesDoc revisoesDoc;
}