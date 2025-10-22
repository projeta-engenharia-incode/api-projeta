package br.com.projeta_api.controller;


import br.com.projeta_api.dto.OrcamentoDTO;
import br.com.projeta_api.model.Orcamento;
import br.com.projeta_api.service.OrcamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orcamentos")
@Tag(name = "Orçamentos", description = "Endpoints para gerenciar orçamentos")
public class OrcamentoController {

    private final OrcamentoService orcamentoService;

    public OrcamentoController(OrcamentoService orcamentoService) {
        this.orcamentoService = orcamentoService;
    }

    @GetMapping("")
    @Operation(summary = "Lista todos os orçamentos", description = "Retorna uma lista de todos os orçamentos cadastrados")
    public ResponseEntity<?> listarOrcamentos() {
        try {
            List<Orcamento> lista = orcamentoService.getAllOrcamentos();
            return ResponseEntity.ok(lista);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @Operation(summary = "Cria um novo orçamento", description = "Registra um novo orçamento")
    public ResponseEntity<?> criarOrcamento(@Valid @RequestBody OrcamentoDTO dto) {
        try {
            OrcamentoDTO criado = orcamentoService.saveOrcamento(dto);
            return new ResponseEntity<>(criado, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um orçamento por ID", description = "Atualiza os dados de um orçamento existente")
    public ResponseEntity<?> atualizarOrcamento(@PathVariable Long id, @Valid @RequestBody OrcamentoDTO dto) {
        try {
            OrcamentoDTO atualizado = orcamentoService.updateOrcamento(id, dto);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um orçamento por ID", description = "Retorna os dados de um orçamento específico")
    public ResponseEntity<?> buscarOrcamentoPorId(@PathVariable Long id) {
        try {
            OrcamentoDTO dto = orcamentoService.getOrcamentoById(id);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um orçamento por ID", description = "Remove um orçamento específico")
    public ResponseEntity<?> deletarOrcamento(@PathVariable Long id) {
        try {
            orcamentoService.deleteOrcamento(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
