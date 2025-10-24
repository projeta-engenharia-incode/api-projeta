package br.com.projeta_api.controller;


import br.com.projeta_api.DTO.request.RevisoesDocDTO;
import br.com.projeta_api.service.RevisoesDocService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/revisoes-doc")
@Tag(name = "Revisões de Documentos", description = "Endpoints para gerenciar revisões de documentos")
public class RevisoesDocController {

    private final RevisoesDocService revisoesDocService;

    public RevisoesDocController(RevisoesDocService revisoesDocService) {
        this.revisoesDocService = revisoesDocService;
    }

    @PostMapping("/create")
    @Operation(summary = "Cria uma nova revisão de documento", description = "Registra uma nova revisão de documento")
    public ResponseEntity<?> criarRevisaoDoc(@Valid @RequestBody RevisoesDocDTO dto) {
        try {
            RevisoesDocDTO createdDto = revisoesDocService.saveRevisaoDoc(dto);
            return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<RevisoesDocDTO>> listarRevisoesDocs() {
        List<RevisoesDocDTO> lista = revisoesDocService.listarRevisoesDocs();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RevisoesDocDTO> getRevisaoDocById(@PathVariable Long id) {
        RevisoesDocDTO dto = revisoesDocService.getRevisaoDocById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza revisão de documento por ID", description = "Atualiza os dados de uma revisão de documento existente")
    public ResponseEntity<?> atualizarRevisaoDoc(@PathVariable Long id, @Valid @RequestBody RevisoesDocDTO dto) {
        try {
            RevisoesDocDTO updatedDto = revisoesDocService.updateRevisaoDoc(id, dto);
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta revisão de documento por ID", description = "Remove uma revisão de documento específica")
    public ResponseEntity<?> deletarRevisaoDoc(@PathVariable Long id) {
        try {
            revisoesDocService.deleteRevisaoDoc(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
