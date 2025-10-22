package br.com.projeta_api.DTO.request;

import br.com.projeta_api.model.Documentos;
import br.com.projeta_api.model.Fornecedores;
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
public class PagamentosFornecedoresDTO {
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private Fornecedores fornecedorId;
    @ManyToOne
    @JoinColumn(name = "documento_id", nullable = false)
    private Documentos documentoId;
    @Column(name = "percentual_pago", precision = 5, scale = 2)
    private Double percentualPago;
    @Column(name = "valor_pago", precision = 14, scale = 2)
    private Double valorPago;
    @Column(name = "data_pagamento")
    private LocalDateTime dataPagamento;
}
