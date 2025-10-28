package br.com.projeta_api.dto.export;


import br.com.projeta_api.model.RejeicoesRevisao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExportRejeicoesRevisaoDto {

    private Long id;
    private String codigoTiposRejeicoes;
    private String revisao;

    public ExportRejeicoesRevisaoDto(RejeicoesRevisao rejeicoesRevisao) {
        this.id = rejeicoesRevisao.getId();
        this.codigoTiposRejeicoes = rejeicoesRevisao.getTiposRejeicoes().getCodigo();
        this.revisao = rejeicoesRevisao.getRevisoesDoc().getRevisao();
    }
}
