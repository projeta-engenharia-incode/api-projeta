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
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "recurso_id", nullable = false)
    private Recurso recursoId;
    @ManyToOne
    @JoinColumn(name = "documento_id", nullable = false)
    private Documentos documentoId;
    @Column(name = "quantidade_usada", length = 11)
    private Integer quantidadeUsada;
    @Column(name = "data_uso")
    private LocalDateTime dataUso;
}
