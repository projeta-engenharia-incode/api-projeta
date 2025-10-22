package br.com.projeta_api.controller;


import br.com.projeta_api.dto.ProjetoDTO;
import br.com.projeta_api.model.Projeto;
import br.com.projeta_api.service.ProjetoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projetos")
@Tag(name = "Projetos", description = "Endpoints para gerenciar projetos")
public class ProjetoController {

    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @GetMapping
    @Operation(summary = "Lista todos os projetos", description = "Retorna todos os projetos cadastrados")
    public ResponseEntity<?> listarProjetos() {
        try {
            return new ResponseEntity<>(projetoService.getAllProjetos(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @Operation(summary = "Cria um projeto", description = "Cria um novo projeto e retorna os dados criados")
    public ResponseEntity<?> criarProjeto(@Valid @RequestBody ProjetoDTO dto) {
        try {
            ProjetoDTO createdDto = projetoService.saveProjeto(dto);
            return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca projeto por ID", description = "Retorna os dados de um projeto específico")
    public ResponseEntity<?> projetoPorId(@PathVariable Long id) {
        try {
            Projeto projeto = projetoService.getProjetoById(id);
            return new ResponseEntity<>(projeto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza projeto por ID", description = "Atualiza os dados de um projeto específico")
    public ResponseEntity<?> atualizarProjeto(@PathVariable Long id, @Valid @RequestBody ProjetoDTO dto) {
        try {
            dto.setId(id);
            ProjetoDTO updatedDto = projetoService.updateProjeto(dto);
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta projeto por ID", description = "Remove um projeto específico")
    public ResponseEntity<?> deletarProjeto(@PathVariable Long id) {
        try {
            projetoService.deleteProjeto(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
