package br.com.projeta_api.dto.export;

import br.com.projeta_api.model.UsoRecursos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExportUsoRecurso {

    private Long id;
    private String nomeRecurso;
    private String nomeDocumento;
    private Integer quantidadeUsada;
    private LocalDateTime dataUso;


    public ExportUsoRecurso(UsoRecursos usoRecursos){
        this.id = usoRecursos.getId();
        this.nomeRecurso = usoRecursos.getRecurso().getNome();
        this.nomeDocumento = usoRecursos.getDocumentos().getCodigoDoc();
        this.quantidadeUsada =  usoRecursos.getQuantidadeUsada();
        this.dataUso = usoRecursos.getDataUso();

    }
}
