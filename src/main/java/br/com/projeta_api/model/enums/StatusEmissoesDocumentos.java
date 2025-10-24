package br.com.projeta_api.model.enums;


import lombok.Getter;

@Getter
public enum StatusEmissoesDocumentos {

    RECEBIDO("RECEBIDO"),
    PENDENTE ("PENDENTE"),
    REJEITADO("REJEITADO");

    private final String status;

    StatusEmissoesDocumentos(String status) {
        this.status = status;
    }
}
