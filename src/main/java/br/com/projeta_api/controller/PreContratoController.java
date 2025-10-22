package br.com.projeta_api.controller;


import br.com.projeta_api.dto.PreContratoDTO;
import br.com.projeta_api.model.PreContrato;
import br.com.projeta_api.service.PreContratoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pre-contratos")
@Tag(name = "Pré-Contratos", description = "Endpoints para gerenciar pré-contratos")
public class PreContratoController {

    private final PreContratoService preContratoService;

    public PreContratoController(PreContratoService preContratoService) {
        this.preContratoService = preContratoService;
    }

    @GetMapping
    @Operation(summary = "Lista todos os pré-contratos", description = "Retorna todos os pré-contratos cadastrados")
    public ResponseEntity<?> listarPreContratos() {
        try {
            return new ResponseEntity<>(preContratoService.getAllPreContratos(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @Operation(summary = "Cria um pré-contrato", description = "Cria um pré-contrato e retorna os dados criados")
    public ResponseEntity<?> criarPreContrato(@Valid @RequestBody PreContratoDTO dto) {
        try {
            PreContratoDTO createdDto = preContratoService.savePreContrato(dto);
            return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca pré-contrato por ID", description = "Retorna os dados de um pré-contrato específico")
    public ResponseEntity<?> preContratoPorId(@PathVariable Long id) {
        try {
            PreContrato preContrato = preContratoService.getPreContratoById(id);
            return new ResponseEntity<>(preContrato, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza pré-contrato por ID", description = "Atualiza os dados de um pré-contrato específico")
    public ResponseEntity<?> atualizarPreContrato(@PathVariable Long id, @Valid @RequestBody PreContratoDTO dto) {
        try {
            dto.setId(id);
            PreContratoDTO updatedDto = preContratoService.updatePreContrato(dto);
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta pré-contrato por ID", description = "Remove um pré-contrato específico")
    public ResponseEntity<?> deletarPreContrato(@PathVariable Long id) {
        try {
            preContratoService.deletePreContrato(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
