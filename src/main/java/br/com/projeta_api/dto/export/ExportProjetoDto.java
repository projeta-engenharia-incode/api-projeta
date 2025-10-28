package br.com.projeta_api.dto.export;

import br.com.projeta_api.model.Projeto;
import br.com.projeta_api.model.enums.StatusProjeto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExportProjetoDto {

    private Long id;
    private String contratoNome;
    private String titulo;
    private String disciplina;
    private StatusProjeto status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ExportProjetoDto(Projeto projeto) {
        this.id = projeto.getId();
        this.contratoNome = projeto.getContrato().getContrato();
        this.titulo = projeto.getTitulo();
        this.disciplina = projeto.getDisciplina();
        this.status = projeto.getStatus();
        this.createdAt = projeto.getCreatedAt();
        this.updatedAt = projeto.getUpdatedAt();


    }
}
