package br.com.projeta_api.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RejeicoesRevisaoDTO {
    private Long id;
    private Long tiposRejeicoesId;
    private Long revisoesDocId;
}
