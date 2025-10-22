package br.com.projeta_api.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CicloDTO {

    private Long id;
    private String nome;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
