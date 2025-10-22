package br.com.projeta_api.controller;


import br.com.projeta_api.DTO.request.TiposRejeicoesDTO;
import br.com.projeta_api.service.TiposRejeicoesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipos-rejeicoes")
@Tag(name = "Tipos de Rejeições", description = "Endpoints para gerenciar tipos de rejeições")
public class TiposRejeicoesController {

    private final TiposRejeicoesService tiposRejeicoesService;

    public TiposRejeicoesController(TiposRejeicoesService tiposRejeicoesService) {
        this.tiposRejeicoesService = tiposRejeicoesService;
    }

    @PostMapping("/create")
    @Operation(summary = "Cria um novo tipo de rejeição", description = "Registra um novo tipo de rejeição")
    public ResponseEntity<?> criarTipoRejeicao(@Valid @RequestBody TiposRejeicoesDTO dto) {
        try {
            TiposRejeicoesDTO createdDto = tiposRejeicoesService.saveTipoRejeicao(dto);
            return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza tipo de rejeição por ID", description = "Atualiza os dados de um tipo de rejeição existente")
    public ResponseEntity<?> atualizarTipoRejeicao(@PathVariable Long id, @Valid @RequestBody TiposRejeicoesDTO dto) {
        try {
            TiposRejeicoesDTO updatedDto = tiposRejeicoesService.updateTipoRejeicao(id, dto);
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta tipo de rejeição por ID", description = "Remove um tipo de rejeição específico")
    public ResponseEntity<?> deletarTipoRejeicao(@PathVariable Long id) {
        try {
            tiposRejeicoesService.deleteTipoRejeicao(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
