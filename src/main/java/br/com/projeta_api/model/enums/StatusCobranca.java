package br.com.projeta_api.model;


import lombok.Getter;

@Getter
public enum StatusCobranca {

    PAGA("PAGA"),
    CANCELADA   ("CANCELADA"),
    EMITIDA ("EMITIDA"),
    VENDIDA    ("VENDIDA");

    private final String status;

    StatusCobranca(String status) {
        this.status = status;
    }
}
