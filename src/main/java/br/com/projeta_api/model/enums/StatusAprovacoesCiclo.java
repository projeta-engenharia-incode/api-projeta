package br.com.projeta_api.model.enums;

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
