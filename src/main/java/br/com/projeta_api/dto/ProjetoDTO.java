package br.com.projeta_api.dto;

import br.com.projeta_api.model.enums.StatusProjeto;
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
    private StatusProjeto status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
