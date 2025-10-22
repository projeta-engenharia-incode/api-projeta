package br.com.projeta_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CicloDTO {

    private Long id;
    private String nome;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
