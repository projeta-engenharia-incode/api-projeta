package br.com.projeta_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "recursos")
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "tipo", length = 50)
    private String tipo;

    @Column(name = "quantidade_total")
    private Integer quantidadeTotal;


}
