package br.com.projeta_api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProjetoDTO {

    private Long id;
    private Long contratoId;
    private String titulo;
    private String disciplina;
    private String statusGeral;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
