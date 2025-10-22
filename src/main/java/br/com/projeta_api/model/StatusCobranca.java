package br.com.projeta_api.model;

public enum StatusCobranca {

    PAGA("PAGA"),
    CANCELADA   ("CANCELADA"),
    EMITIDA ("EMITIDA"),
    VENDIDA    ("VENDIDA");

    private final String role;

    StatusCobranca(String role) {
        this.role = role;
    }
}
