package br.com.projeta_api.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentosDTO {
    private Long id;
    private Integer projetoId;
    private Integer cicloId;
    private String codigoDoc;
    private String tituloSecundario;
    private String tipo;
    private String formato;
    private String categoria;
    private String descricao;
    private String statusDocumento;
    private String etapa;
    private String responsavel;
    private String auxiliar;
    private String numProjeta;
    private String numCliente;
    private String numSe;
    private String datas;
    private Integer qtdPrevista;
    private BigDecimal multiplicador;
    private String itemQqf;
    private BigDecimal equivalentePrevisto;
    private BigDecimal equivalenteEntregue;
    private BigDecimal valorUnitario;
    private BigDecimal valorPrevisto;
    private BigDecimal valorEntregue;
    private BigDecimal valorReajustado;
    private BigDecimal percentualExecucao;
    private String observacao;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
