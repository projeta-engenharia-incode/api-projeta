package br.com.projeta_api.controller;


import br.com.projeta_api.dto.CobrancasDTO;
import br.com.projeta_api.service.CobrancasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cobrancas")
@Tag(name = "Cobranças", description = "Endpoints para gerenciar cobranças")
public class CobrancasController {

    private final CobrancasService cobrancasService;

    public CobrancasController(CobrancasService cobrancasService) {
        this.cobrancasService = cobrancasService;
    }

    @GetMapping
    @Operation(summary = "Lista todas as cobranças", description = "Retorna uma lista de todas as cobranças cadastradas")
    public ResponseEntity<?> listarCobrancas() {
        try {
            return new ResponseEntity<>(cobrancasService.listarCobrancas(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @Operation(summary = "Cria uma nova cobrança", description = "Cria uma cobrança e retorna os dados da cobrança criada")
    public ResponseEntity<?> criarCobranca(@Valid @RequestBody CobrancasDTO dto) {
        try {
            CobrancasDTO createdDto = cobrancasService.criarCobranca(dto);
            return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma cobrança pelo ID", description = "Retorna os detalhes de uma cobrança específica")
    public ResponseEntity<?> buscarCobrancaPorId(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(cobrancasService.buscarCobrancaPorId(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma cobrança pelo ID", description = "Atualiza as informações de uma cobrança existente")
    public ResponseEntity<?> atualizarCobranca(@PathVariable Long id, @Valid @RequestBody CobrancasDTO dto) {
        try {
            CobrancasDTO updatedDto = cobrancasService.atualizarCobranca(id, dto);
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma cobrança pelo ID", description = "Remove uma cobrança específica")
    public ResponseEntity<?> deletarCobranca(@PathVariable Long id) {
        try {
            cobrancasService.deletarCobranca(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
