package br.com.projeta_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tipos_rejeicoes")
public class TiposRejeicoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", length = 18, nullable = false)
    private String codigo;
    @Column(name = "descricao",columnDefinition = "TEXT")
    private String descricao;

    @OneToMany(mappedBy = "tiposRejeicoes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RejeicoesRevisao> rejeicoes;
}
