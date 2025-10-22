package br.com.projeta_api.controller;

import br.com.projeta_api.DTO.request.EmissaoDocumentoDTO;
import br.com.projeta_api.service.EmissoesDocumentosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emissoes-documentos")
@Tag(name = "Emissões de Documentos", description = "Endpoints para gerenciar emissões de documentos")
public class EmissoesDocumentosController {


    private final EmissoesDocumentosService emissoesDocumentosService;

    public EmissoesDocumentosController(EmissoesDocumentosService emissoesDocumentosService) {
        this.emissoesDocumentosService = emissoesDocumentosService;
    }

    @GetMapping
    @Operation(summary = "Lista todas as emissões de documentos", description = "Retorna uma lista de todas as emissões cadastradas")
    public ResponseEntity<?> listarEmissoes() {
        try {
            return new ResponseEntity<>(emissoesDocumentosService.listarEmissoesDocumentos(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @Operation(summary = "Cria uma nova emissão de documento", description = "Cria uma emissão de documento e retorna os dados criados")
    public ResponseEntity<?> criarEmissao(@Valid @RequestBody EmissaoDocumentoDTO dto) {
        try {
            EmissaoDocumentoDTO createdDto = emissoesDocumentosService.saveEmissaoDocumento(dto);
            return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma emissão de documento pelo ID", description = "Retorna os detalhes de uma emissão específica")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(emissoesDocumentosService.getEmissaoDocumentoById(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma emissão de documento pelo ID", description = "Atualiza os dados de uma emissão existente")
    public ResponseEntity<?> atualizarEmissao(@PathVariable Long id, @Valid @RequestBody EmissaoDocumentoDTO dto) {
        try {
            EmissaoDocumentoDTO updatedDto = emissoesDocumentosService.updateEmissaoDocumento(id, dto);
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma emissão de documento pelo ID", description = "Remove uma emissão específica")
    public ResponseEntity<?> deletarEmissao(@PathVariable Long id) {
        try {
            emissoesDocumentosService.deleteEmissaoDocumento(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }





}
