package br.com.projeta_api.model.enums;


import lombok.Getter;

@Getter
public enum StatusEntregaCiclo {

    PAGA("PAGA"),
    PENDENTE("PENDENTE");


    private final String status;

    StatusEntregaCiclo(String status) {
        this.status = status;
    }

}
