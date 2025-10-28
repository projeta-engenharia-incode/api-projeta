package br.com.projeta_api.dto.export;


import br.com.projeta_api.DTO.request.FornecedoresDTO;
import br.com.projeta_api.model.Fornecedores;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.math3.analysis.function.Exp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExportForncedoresDto {

    private Long id;
    private String nomeContrato;
    private String nome;
    private String tipo;


    public ExportForncedoresDto(Fornecedores fornecedores) {
        this.id = fornecedores.getId();
        this.nomeContrato = fornecedores.getContrato().getContrato();
        this.nome = fornecedores.getNome();
        this.tipo = fornecedores.getTipo();
    }
}
