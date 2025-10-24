package br.com.projeta_api.model.enums;


import lombok.Getter;

@Getter
public enum StatusRevisoesDoc {

    APROVADO("APROVADO"),
    EM_ANALISE("EM_ANALISE"),
    REJEITADO("REJEITADO");

    private final String status;

    StatusRevisoesDoc(String status) {
        this.status = status;
    }
}
