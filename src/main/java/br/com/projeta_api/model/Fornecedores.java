package br.com.projeta_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fornecedores")
public class Fornecedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;
    @Column(name = "nome", length = 120)
    private String nome;
    @Column(name = "tipo", length = 60)
    private String tipo;

    @OneToMany(mappedBy = "fornecedores", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PagamentosFornecedores> pagamentosFornecedores = new ArrayList<>();
}
