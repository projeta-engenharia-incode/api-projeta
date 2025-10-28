package br.com.projeta_api.dto.export;


import br.com.projeta_api.model.ResponsaveisDocumento;
import br.com.projeta_api.model.enums.StatusResponsaveisDocumentos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExportResponsaveisDocumentosDto {

    private Long id;
    private String nomeDocumento;
    private String nome;
    private StatusResponsaveisDocumentos status;
    private String funcao;
    private String nomeUsuario;

    public ExportResponsaveisDocumentosDto(ResponsaveisDocumento  responsaveisDocumento) {
        this.id = responsaveisDocumento.getId();
        this.nomeDocumento = responsaveisDocumento.getDocumento().getCodigoDoc();
        this.nome = responsaveisDocumento.getNome();
        this.status = responsaveisDocumento.getStatus();
        this.funcao = responsaveisDocumento.getFuncao();
        this.nomeUsuario = responsaveisDocumento.getUsuario().getNome();
    }
}
