package br.com.projeta_api.dto.export;

import br.com.projeta_api.model.RevisoesDoc;
import br.com.projeta_api.model.enums.StatusRevisoesDoc;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExportRevisoesDoc {


    private Long id;
    private String revisao;
    private String nomeDocumento;
    private String responsavel;
    private LocalDateTime dataEnvio;
    private LocalDateTime dataRespostaCiclo;
    private StatusRevisoesDoc status;
    private String observacoes;

    public ExportRevisoesDoc(RevisoesDoc revisoesDoc){
        this.id = revisoesDoc.getId();
        this.revisao = revisoesDoc.getRevisao();
        this.nomeDocumento = revisoesDoc.getDocumentos().getCodigoDoc();
        this.responsavel = revisoesDoc.getResponsavel();
        this.dataEnvio = revisoesDoc.getDataEnvio();
        this.status = revisoesDoc.getStatus();
        this.observacoes = revisoesDoc.getObservacoes();
    }
}
