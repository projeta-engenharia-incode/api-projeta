package br.com.projeta_api.dto.export;

import br.com.projeta_api.model.Contrato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExportContratoDto {

    private Long id;
    private String codigo;
    private String contrato;
    private String subcontrato;
    private String empresa;
    private String gestor;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private BigDecimal valorTotal;
    private Integer revisao;
    private String tituloPreContrato;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ExportContratoDto(Contrato  contrato) {
        this.id = contrato.getId();
        this.codigo = contrato.getCodigo();
        this.contrato = contrato.getContrato();
        this.subcontrato = contrato.getSubcontrato();
        this.empresa = contrato.getEmpresa();
        this.gestor = contrato.getGestor();
        this.dataInicio = contrato.getDataInicio();
        this.dataFim = contrato.getDataFim();
        this.valorTotal = contrato.getValorTotal();
        this.revisao = contrato.getRevisao();
        this.tituloPreContrato = contrato.getPreContrato().getTitulo();
        this.createdAt = contrato.getCreatedAt();
        this.updatedAt = contrato.getUpdatedAt();

    }
}
