package br.com.projeta_api.dto.export;


import br.com.projeta_api.model.TiposRejeicoes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExportTiposRejeicoes {


    private Long id;
    private String codigo;
    private String descricao;


    public ExportTiposRejeicoes(TiposRejeicoes tiposRejeicoes){
        this.id = tiposRejeicoes.getId();
        this.codigo = tiposRejeicoes.getCodigo();
        this.descricao = tiposRejeicoes.getDescricao();
    }
}
