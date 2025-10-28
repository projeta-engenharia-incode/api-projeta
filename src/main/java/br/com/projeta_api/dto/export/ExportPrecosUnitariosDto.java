package br.com.projeta_api.dto.export;


import br.com.projeta_api.model.PreContrato;
import br.com.projeta_api.model.PrecosUnitarios;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExportPrecosUnitariosDto {

    private Long id;
    private String nomeContrato;
    private String codigo;
    private String categoria;
    private String descricao;
    private String formato;
    private Integer quantidade;
    private BigDecimal precoUnitario;

    public ExportPrecosUnitariosDto(PrecosUnitarios precosUnitarios){
        this.id = precosUnitarios.getId();
        this.nomeContrato = precosUnitarios.getContrato().getCodigo();
        this.codigo = precosUnitarios.getCodigo();
        this.categoria = precosUnitarios.getCategoria();
        this.descricao = precosUnitarios.getDescricao();
        this.formato = precosUnitarios.getFormato();
        this.quantidade = precosUnitarios.getQuantidade();
        this.precoUnitario = precosUnitarios.getPrecoUnitario();
    }
}
