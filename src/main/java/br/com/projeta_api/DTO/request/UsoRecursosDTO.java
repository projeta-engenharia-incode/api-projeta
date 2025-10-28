package br.com.projeta_api.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsoRecursosDTO {
    private Long id;
    private Long recursoId;
    private Long documentoId;
    private Integer quantidadeUsada;
    private LocalDateTime dataUso;
}
