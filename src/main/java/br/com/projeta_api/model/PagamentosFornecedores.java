package br.com.projeta_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @Column(name = "fornecedor_id", length = 20)
    private Integer fornecedorId;
    @Column(name = "documento_id", length = 20)
    private Integer documentoId;
    @Column(name = "percentual_pago", precision = 5, scale = 2)
    private Double percentualPago;
    @Column(name = "valor_pago", precision = 14, scale = 2)
    private Double valorPago;
    @Column(name = "data_pagamento")
    private LocalDateTime dataPagamento;
}
