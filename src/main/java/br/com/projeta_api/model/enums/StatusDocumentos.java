package br.com.projeta_api.model.enums;


import lombok.Getter;

@Getter
public enum StatusDocumentos {

    APROVADO("APROVADO"),
    PENDENCIA_EXTERNA ("PENDENCIA_EXTERNA"),
    EM_ELABORACAO("EM_ELABORACAO"),
    ENVIADO("ENVIADO"),
    REJEITADO("REJEITADO");


    private final String status;

    StatusDocumentos(String status) {
        this.status = status;
    }

}
