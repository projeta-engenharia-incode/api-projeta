package br.com.projeta_api.DTO.request;

import br.com.projeta_api.model.Documentos;
import br.com.projeta_api.model.Fornecedores;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentosFornecedoresDTO {
    private Long id;
    private Long fornecedorId;
    private Long documentoId;
    private BigDecimal percentualPago;
    private BigDecimal valorPago;
    private LocalDateTime dataPagamento;
}
