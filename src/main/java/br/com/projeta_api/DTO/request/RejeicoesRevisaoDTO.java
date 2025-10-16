package br.com.projeta_api.DTO.request;

import br.com.projeta_api.model.RevisoesDoc;
import br.com.projeta_api.model.TiposRejeicoes;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RejeicoesRevisaoDTO {
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "tipos_rejeicoes_id", nullable = false)
    private TiposRejeicoes tiposRejeicoes;
    @ManyToOne
    @JoinColumn(name = "id_revisoes", nullable = false)
    private RevisoesDoc revisoesDoc;
}
