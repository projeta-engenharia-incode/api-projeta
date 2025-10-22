package br.com.projeta_api.controller;


import br.com.projeta_api.DTO.request.ContratoDTO;
import br.com.projeta_api.service.ContratoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contratos")
@Tag(name = "Contratos", description = "Endpoints para gerenciar contratos")
public class ContratoController {

    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @GetMapping
    @Operation(summary = "Lista todos os contratos", description = "Retorna uma lista de todos os contratos cadastrados")
    public ResponseEntity<?> listarContratos() {
        try {
            return new ResponseEntity<>(contratoService.listarContratos(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @Operation(summary = "Cria um novo contrato", description = "Cria um contrato e retorna os dados do contrato criado")
    public ResponseEntity<?> criarContrato(@Valid @RequestBody ContratoDTO dto) {
        try {
            ContratoDTO createdDto = contratoService.saveContrato(dto);
            return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um contrato pelo ID", description = "Retorna os detalhes de um contrato específico")
    public ResponseEntity<?> buscarContratoPorId(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(contratoService.getContratoById(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um contrato pelo ID", description = "Atualiza as informações de um contrato existente")
    public ResponseEntity<?> atualizarContrato(@PathVariable Long id, @Valid @RequestBody ContratoDTO dto) {
        try {
            ContratoDTO updatedDto = contratoService.updateContrato(id, dto);
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um contrato pelo ID", description = "Remove um contrato específico")
    public ResponseEntity<?> deletarContrato(@PathVariable Long id) {
        try {
            contratoService.deleteContrato(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
