package br.com.projeta_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pagamentos_forn")
public class PagamentosFornecedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private Fornecedores fornecedorId;
    @ManyToOne
    @JoinColumn(name = "documento_id", nullable = false)
    private Documentos documentoId;
    @Column(name = "percentual_pago", precision = 5, scale = 2)
    private BigDecimal percentualPago;
    @Column(name = "valor_pago", precision = 14, scale = 2)
    private BigDecimal valorPago;
    @Column(name = "data_pagamento")
    private LocalDateTime dataPagamento;
}
