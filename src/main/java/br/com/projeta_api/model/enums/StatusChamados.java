package br.com.projeta_api.model.enums;


import lombok.Getter;

@Getter
public enum StatusChamados {

    ORCADO("ORCADO"),
    NAO_ORCADO ("NAO_ORCADO");

    private final String status;

    StatusChamados(String status) {
        this.status = status;
    }
}
