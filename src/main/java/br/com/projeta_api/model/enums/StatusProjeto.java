package br.com.projeta_api.model.enums;

import lombok.Getter;

@Getter
public enum StatusProjeto {

    CANCELADO("CANCELADO"),
    PENDENCIA_EXTERNA("PENDENCIA_EXTERNA"),
    CONCLUIDO("CONCLUIDO");


    private final String status;

    StatusProjeto(String status) {
        this.status = status;
    }
}

