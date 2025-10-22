package br.com.projeta_api.controller;

import br.com.projeta_api.dto.ChamadosDTO;
import br.com.projeta_api.service.ChamadosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chamados")
@Tag(name = "Chamados", description = "Endpoints para gerenciar chamados")
public class ChamadosController {

    private final ChamadosService chamadosService;

    public ChamadosController(ChamadosService chamadosService) {
        this.chamadosService = chamadosService;
    }

    @GetMapping
    @Operation(summary = "Lista todos os chamados", description = "Retorna uma lista com todos os chamados cadastrados")
    public ResponseEntity<?> listarTodosChamados() {
        try {
            return new ResponseEntity<>(chamadosService.listarTodos(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @Operation(summary = "Cria um novo chamado", description = "Cria um chamado e retorna os dados do chamado criado")
    public ResponseEntity<?> criarChamado(@Valid @RequestBody ChamadosDTO dto) {
        try {
            ChamadosDTO createdDto = chamadosService.criarChamado(dto);
            return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um chamado pelo ID", description = "Retorna os detalhes de um chamado específico")
    public ResponseEntity<?> buscarChamadoPorId(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(chamadosService.buscarPorId(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um chamado pelo ID", description = "Atualiza as informações de um chamado existente")
    public ResponseEntity<?> atualizarChamado(@PathVariable Long id, @Valid @RequestBody ChamadosDTO dto) {
        try {
            ChamadosDTO updatedDto = chamadosService.atualizarChamado(id, dto);
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um chamado pelo ID", description = "Remove um chamado específico")
    public ResponseEntity<?> deletarChamado(@PathVariable Long id) {
        try {
            chamadosService.deletarChamado(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
