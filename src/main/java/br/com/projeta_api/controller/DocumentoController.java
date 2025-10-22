package br.com.projeta_api.controller;

import br.com.projeta_api.DTO.request.DocumentosDTO;
import br.com.projeta_api.service.DocumentosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documentos")
@Tag(name = "Documentos", description = "Endpoints para gerenciar documentos")
public class DocumentoController {

    private final DocumentosService documentosService;

    public DocumentoController(DocumentosService documentosService) {
        this.documentosService = documentosService;
    }

    @GetMapping
    @Operation(summary = "Lista todos os documentos", description = "Retorna uma lista de todos os documentos cadastrados")
    public ResponseEntity<?> listarDocumentos() {
        try {
            return new ResponseEntity<>(documentosService.listarDocumentos(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @Operation(summary = "Cria um novo documento", description = "Cria um documento e retorna os dados do documento criado")
    public ResponseEntity<?> criarDocumento(@Valid @RequestBody DocumentosDTO dto) {
        try {
            DocumentosDTO createdDto = documentosService.criarDocumento(dto);
            return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um documento pelo ID", description = "Retorna os detalhes de um documento específico")
    public ResponseEntity<?> buscarDocumentoPorId(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(documentosService.documentosPorId(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um documento pelo ID", description = "Atualiza as informações de um documento existente")
    public ResponseEntity<?> atualizarDocumento(@PathVariable Long id, @Valid @RequestBody DocumentosDTO dto) {
        try {
            DocumentosDTO updatedDto = documentosService.atualizarDocumento(id, dto);
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um documento pelo ID", description = "Remove um documento específico")
    public ResponseEntity<?> deletarDocumento(@PathVariable Long id) {
        try {
            documentosService.deletarDocumento(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
