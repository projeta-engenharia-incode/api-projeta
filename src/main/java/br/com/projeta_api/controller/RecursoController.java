package br.com.projeta_api.controller;


import br.com.projeta_api.dto.RecursoDTO;
import br.com.projeta_api.model.Recurso;
import br.com.projeta_api.service.RecursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recurso")
@Tag(name = "Recursos", description = "Endpoints para gerenciar recursos")
public class    RecursoController {

    private final RecursoService recursoService;

    public RecursoController(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    @GetMapping
    @Operation(summary = "Lista todos os recursos", description = "Retorna todos os recursos cadastrados")
    public ResponseEntity<?> listarRecursos() {
        try {
            return new ResponseEntity<>(recursoService.getAllRecursos(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @Operation(summary = "Cria um recurso", description = "Cria um novo recurso e retorna os dados criados")
    public ResponseEntity<?> criarRecurso(@Valid @RequestBody RecursoDTO dto) {
        try {
            RecursoDTO createdDto = recursoService.saveRecurso(dto);
            return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca recurso por ID", description = "Retorna os dados de um recurso específico")
    public ResponseEntity<?> recursoPorId(@PathVariable Long id) {
        try {
            Recurso recurso = recursoService.getRecursoById(id);
            return new ResponseEntity<>(recurso, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza recurso por ID", description = "Atualiza os dados de um recurso específico")
    public ResponseEntity<?> atualizarRecurso(@PathVariable Long id, @Valid @RequestBody RecursoDTO dto) {
        try {
            dto.setId(id);
            RecursoDTO updatedDto = recursoService.updateRecurso(dto);
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta recurso por ID", description = "Remove um recurso específico")
    public ResponseEntity<?> deletarRecurso(@PathVariable Long id) {
        try {
            recursoService.deleteRecurso(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
