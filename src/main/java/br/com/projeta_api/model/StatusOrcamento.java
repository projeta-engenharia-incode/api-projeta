package br.com.projeta_api.model;


import lombok.Getter;

@Getter
public enum StatusOrcamento {

    APROVADO("APROVADO"),
    AGUARDANDO_APROVACAO("AGUARDANDO_APROVACAO"),
    EM_ELABORACAO("EM_ELABORACAO"),
    ENVIADO    ("ENVIADO"),
    REJEITADO("REJEITADO");

    private final String status;

    StatusOrcamento(String status) {
        this.status = status;
    }
}
