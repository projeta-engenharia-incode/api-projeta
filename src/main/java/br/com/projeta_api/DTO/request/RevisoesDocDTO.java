package br.com.projeta_api.DTO.request;

import br.com.projeta_api.model.enums.StatusRevisoesDoc;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevisoesDocDTO {
    private Long id;
    private String revisao;
    private String responsavel;
    private LocalDateTime dataEnvio;
    private LocalDateTime dataRespostaCiclo;
    private StatusRevisoesDoc status;
    private String observacoes;
    //private List<Long> rejeicoesIds;
}
