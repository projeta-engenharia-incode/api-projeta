package br.com.projeta_api.DTO.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FornecedoresDTO {
    @Column(name = "id")
    private Long id;
    @Column(name = "contrato_id", length = 11)
    private Integer contrato_id;
    @Column(name = "nome", length = 120)
    private String nome;
    @Column(name = "tipo", length = 60)
    private String tipo;
}
