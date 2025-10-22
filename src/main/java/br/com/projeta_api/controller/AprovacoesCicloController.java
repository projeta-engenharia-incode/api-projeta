package br.com.projeta_api.controller;

import br.com.projeta_api.DTO.request.AprovacoesCicloDTO;
import br.com.projeta_api.service.AprovacoesCicloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("aprovacoes-ciclo")
@Tag(name = "Aprovações de Ciclo", description = "Endpoints para gerenciar aprovações de ciclo")
public class AprovacoesCicloController {

    private final AprovacoesCicloService aprovacoesCicloService;

    public AprovacoesCicloController(AprovacoesCicloService aprovacoesCicloService) {
        this.aprovacoesCicloService = aprovacoesCicloService;
    }

    @GetMapping
    @Operation(summary = "Lista todas as aprovações de ciclo", description = "Retorna todas as aprovações de ciclo cadastradas")
    public ResponseEntity<?> listarAprovacoesCiclos() {
        try {
            return new ResponseEntity<>(aprovacoesCicloService.listarAprovacoesCiclos(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @Operation(summary = "Cria uma nova aprovação de ciclo", description = "Cria uma aprovação de ciclo e retorna o DTO criado")
    public ResponseEntity<?> salvarAprovacaoCiclo(@Valid @RequestBody AprovacoesCicloDTO dto) {
        try {
            AprovacoesCicloDTO createdDto = aprovacoesCicloService.saveAprovacaoCiclo(dto);
            return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma aprovação de ciclo pelo ID", description = "Retorna os detalhes de uma aprovação de ciclo específica")
    public ResponseEntity<?> getAprovacaoCicloById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(aprovacoesCicloService.getAprovacaoCicloById(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma aprovação de ciclo pelo ID", description = "Atualiza os dados de uma aprovação de ciclo existente")
    public ResponseEntity<?> atualizarAprovacaoCiclo(@PathVariable Long id, @Valid @RequestBody AprovacoesCicloDTO dto) {
        try {
            AprovacoesCicloDTO updatedDto = aprovacoesCicloService.updateAprovacaoCiclo(id, dto);
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma aprovação de ciclo pelo ID", description = "Remove uma aprovação de ciclo específica")
    public ResponseEntity<?> deletarAprovacaoCiclo(@PathVariable Long id) {
        try {
            aprovacoesCicloService.deleteAprovacaoCiclo(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
