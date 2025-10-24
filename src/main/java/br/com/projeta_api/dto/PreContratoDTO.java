package br.com.projeta_api.dto;

import br.com.projeta_api.model.enums.StatusOrcamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreContratoDTO {

    private Long id;
    private Long chamadoId;
    private String titulo;
    private String descricao;
    private StatusOrcamento status;
    private BigDecimal valorEstimado;
    private LocalDate dataProposta;
    private LocalDate dataValidade;
    private LocalDateTime createdAt;
    private List<Long> contratoIds;
}
