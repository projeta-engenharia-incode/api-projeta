package br.com.projeta_api.DTO.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TiposRejeicoesDTO {
    private Long id;
    @Column(name = "codigo", length = 18, nullable = false)
    private String codigo;
    @Column(name = "descricao",columnDefinition = "TEXT")
    private String descricao;
}
