package br.com.projeta_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoDTO {

    private Long id;
    private Long contratoId;
    private String titulo;
    private String disciplina;
    private String statusGeral;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
