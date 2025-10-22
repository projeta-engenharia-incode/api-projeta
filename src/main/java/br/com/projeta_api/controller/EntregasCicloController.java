package br.com.projeta_api.controller;


import br.com.projeta_api.dto.EntregasCicloDTO;
import br.com.projeta_api.model.EntregasCiclo;
import br.com.projeta_api.service.EntregasCicloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entregas-ciclo")
@Tag(name = "Entregas de Ciclo", description = "Endpoints para gerenciar entregas de ciclo")
public class EntregasCicloController {

    private final EntregasCicloService entregasCicloService;

    public EntregasCicloController(EntregasCicloService entregasCicloService) {
        this.entregasCicloService = entregasCicloService;
    }

    @GetMapping
    @Operation(summary = "Lista todas as entregas de ciclo", description = "Retorna uma lista de todas as entregas de ciclo")
    public ResponseEntity<?> listarEntregas() {
        try {
            return new ResponseEntity<>(entregasCicloService.getAllEntregas(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @Operation(summary = "Cria uma nova entrega de ciclo", description = "Cria uma entrega de ciclo e retorna os dados criados")
    public ResponseEntity<?> criarEntrega(@Valid @RequestBody EntregasCicloDTO dto) {
        try {
            EntregasCicloDTO createdDto = entregasCicloService.saveEntrega(dto);
            return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma entrega de ciclo pelo ID", description = "Retorna os detalhes de uma entrega específica")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            EntregasCiclo entrega = entregasCicloService.getEntregaById(id);
            return new ResponseEntity<>(entrega, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma entrega de ciclo pelo ID", description = "Atualiza os dados de uma entrega existente")
    public ResponseEntity<?> atualizarEntrega(@PathVariable Long id, @Valid @RequestBody EntregasCicloDTO dto) {
        try {
            dto.setId(id);
            EntregasCicloDTO updatedDto = entregasCicloService.updateEntrega(dto);
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma entrega de ciclo pelo ID", description = "Remove uma entrega específica")
    public ResponseEntity<?> deletarEntrega(@PathVariable Long id) {
        try {
            entregasCicloService.deleteEntrega(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
