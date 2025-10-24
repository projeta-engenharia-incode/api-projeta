package br.com.projeta_api.model.enums;

import lombok.Getter;

@Getter
public enum StatusResponsaveisDocumentos {


    ELABORADOR("ELABORADOR"),
    APROVADOR ("APROVADOR"),
    REVISOR("REVISOR");

    private final String status;

    StatusResponsaveisDocumentos(String status) {
        this.status = status;
    }
}
