package br.com.projeta_api.dto.export;


import br.com.projeta_api.model.PreContrato;
import br.com.projeta_api.model.enums.StatusOrcamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExportPreContratoDto {

    private Long id;
    private String nomeChamado;
    private String titulo;
    private String descricao;
    private StatusOrcamento status;
    private BigDecimal valorEstimado;
    private LocalDate dataProposta;
    private LocalDate dataValidade;
    private LocalDateTime createdAt;

    public ExportPreContratoDto(PreContrato preContrato) {
        this.id = preContrato.getId();
        this.nomeChamado = preContrato.getChamado().getNomeProjeto();
        this.titulo = preContrato.getTitulo();
        this.descricao = preContrato.getDescricao();
        this.status = preContrato.getStatus();
        this.valorEstimado = preContrato.getValorEstimado();
        this.dataProposta = preContrato.getDataProposta();
        this.dataValidade = preContrato.getDataValidade();
        this.createdAt = preContrato.getCreatedAt();
    }
}
