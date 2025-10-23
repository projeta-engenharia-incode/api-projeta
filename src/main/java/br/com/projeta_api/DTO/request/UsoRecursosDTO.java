package br.com.projeta_api.DTO.request;

import br.com.projeta_api.model.Documentos;
import br.com.projeta_api.model.Recurso;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
