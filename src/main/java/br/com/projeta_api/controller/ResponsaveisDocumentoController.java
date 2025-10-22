package br.com.projeta_api.controller;


import br.com.projeta_api.dto.ResponsaveisDocumentoDTO;
import br.com.projeta_api.model.ResponsaveisDocumento;
import br.com.projeta_api.service.ResponsaveisDocumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/responsaveis-documento")
@Tag(name = "Responsáveis por Documento", description = "Endpoints para gerenciar responsáveis por documentos")
public class ResponsaveisDocumentoController {

    private final ResponsaveisDocumentoService responsaveisDocumentoService;

    public ResponsaveisDocumentoController(ResponsaveisDocumentoService responsaveisDocumentoService) {
        this.responsaveisDocumentoService = responsaveisDocumentoService;
    }

    @GetMapping
    @Operation(summary = "Lista todos os responsáveis por documento", description = "Retorna todos os responsáveis cadastrados")
    public ResponseEntity<?> listarTodos() {
        try {
            return new ResponseEntity<>(responsaveisDocumentoService.listarTodos(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @Operation(summary = "Cria um responsável por documento", description = "Cria um novo responsável por documento e retorna os dados criados")
    public ResponseEntity<?> criarResponsavel(@Valid @RequestBody ResponsaveisDocumentoDTO dto) {
        try {
            ResponsaveisDocumentoDTO createdDto = responsaveisDocumentoService.criar(dto);
            return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca responsável por documento por ID", description = "Retorna os dados de um responsável específico")
    public ResponseEntity<?> responsavelPorId(@PathVariable Long id) {
        try {
            ResponsaveisDocumento entity = responsaveisDocumentoService.buscarPorId(id);
            return new ResponseEntity<>(entity, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza responsável por documento por ID", description = "Atualiza os dados de um responsável específico")
    public ResponseEntity<?> atualizarResponsavel(@PathVariable Long id, @Valid @RequestBody ResponsaveisDocumentoDTO dto) {
        try {
            dto.setId(id);
            ResponsaveisDocumentoDTO updatedDto = responsaveisDocumentoService.atualizar(dto);
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta responsável por documento por ID", description = "Remove um responsável específico")
    public ResponseEntity<?> deletarResponsavel(@PathVariable Long id) {
        try {
            responsaveisDocumentoService.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
