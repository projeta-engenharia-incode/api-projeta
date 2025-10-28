package br.com.projeta_api.dto.export;


import br.com.projeta_api.model.Recurso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExportRecursoDto {

    private Long id;
    private String nome;
    private String tipo;
    private Integer quantidadeTotal;

    public ExportRecursoDto(Recurso recurso){
        this.id = recurso.getId();
        this.nome = recurso.getNome();
        this.tipo = recurso.getTipo();
        this.quantidadeTotal = recurso.getQuantidadeTotal();
    }
}
