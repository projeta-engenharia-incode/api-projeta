package br.com.projeta_api.model;

import lombok.Getter;

@Getter
public enum StatusAprovacoesCiclo {

    APROVADO("APROVADO"),
    ANALISE ("ANALISE"),
    REJEITADO ("REJEITADO");

    private final String status;

    StatusAprovacoesCiclo(String status) {
        this.status = status;
    }
}
