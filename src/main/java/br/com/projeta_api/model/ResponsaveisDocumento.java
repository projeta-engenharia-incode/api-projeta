package br.com.projeta_api.model;

import br.com.projeta_api.model.enums.StatusResponsaveisDocumentos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "responsaveis_documento")
@AllArgsConstructor
@NoArgsConstructor
public class ResponsaveisDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "documento_id", referencedColumnName = "id")
    private Documentos documento;

    @Column(name = "nome", length = 120)
    private String nome;

    @Column(name = "funcao", length = 60)
    private String funcao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusResponsaveisDocumentos status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;
}
