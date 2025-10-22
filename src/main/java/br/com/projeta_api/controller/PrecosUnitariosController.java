package br.com.projeta_api.controller;


import br.com.projeta_api.DTO.request.PrecosUnitariosDTO;
import br.com.projeta_api.service.PrecosUnitariosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/precos-unitarios")
@Tag(name = "Preços Unitários", description = "Endpoints para gerenciar preços unitários")
public class PrecosUnitariosController {

    private final PrecosUnitariosService precosUnitariosService;

    public PrecosUnitariosController(PrecosUnitariosService precosUnitariosService) {
        this.precosUnitariosService = precosUnitariosService;
    }

    @GetMapping
    @Operation(summary = "Lista todos os preços unitários", description = "Retorna todos os preços unitários cadastrados")
    public ResponseEntity<?> listarPrecosUnitarios() {
        try {
            return new ResponseEntity<>(precosUnitariosService.listarPrecosUnitarios(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @Operation(summary = "Cria um preço unitário", description = "Cria um preço unitário e retorna os dados criados")
    public ResponseEntity<?> criarPrecoUnitario(@Valid @RequestBody PrecosUnitariosDTO dto) {
        try {
            PrecosUnitariosDTO createdDto = precosUnitariosService.savePrecoUnitario(dto);
            return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca preço unitário por ID", description = "Retorna os dados de um preço unitário específico")
    public ResponseEntity<?> precoUnitarioPorId(@PathVariable Long id) {
        try {
            PrecosUnitariosDTO dto = precosUnitariosService.getPrecoUnitarioById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza preço unitário por ID", description = "Atualiza os dados de um preço unitário específico")
    public ResponseEntity<?> atualizarPrecoUnitario(@PathVariable Long id, @Valid @RequestBody PrecosUnitariosDTO dto) {
        try {
            PrecosUnitariosDTO updatedDto = precosUnitariosService.updatePrecoUnitario(id, dto);
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta preço unitário por ID", description = "Remove um preço unitário específico")
    public ResponseEntity<?> deletarPrecoUnitario(@PathVariable Long id) {
        try {
            precosUnitariosService.deletePrecoUnitario(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
