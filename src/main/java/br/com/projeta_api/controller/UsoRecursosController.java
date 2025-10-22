package br.com.projeta_api.controller;


import br.com.projeta_api.DTO.request.UsoRecursosDTO;
import br.com.projeta_api.service.UsoRecursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uso-recursos")
@Tag(name = "Uso de Recursos", description = "Endpoints para gerenciar o uso de recursos em documentos")
public class UsoRecursosController {

    private final UsoRecursoService usoRecursosService;

    public UsoRecursosController(UsoRecursoService usoRecursosService) {
        this.usoRecursosService = usoRecursosService;
    }

    @GetMapping
    @Operation(summary = "Lista todos os usos de recursos", description = "Retorna todos os registros de uso de recursos")
    public ResponseEntity<?> listarTodos() {
        try {
            return new ResponseEntity<>(usoRecursosService.listarUsoRecursos(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @Operation(summary = "Registra um uso de recurso", description = "Cria um novo registro de uso de recurso")
    public ResponseEntity<?> criarUsoRecurso(@Valid @RequestBody UsoRecursosDTO dto) {
        try {
            UsoRecursosDTO createdDto = usoRecursosService.saveUsoRecurso(dto);
            return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca uso de recurso por ID", description = "Retorna os dados de um registro de uso de recurso específico")
    public ResponseEntity<?> usoRecursoPorId(@PathVariable Long id) {
        try {
            UsoRecursosDTO dto = usoRecursosService.getUsoRecursoById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uso de recurso por ID", description = "Atualiza os dados de um registro de uso de recurso")
    public ResponseEntity<?> atualizarUsoRecurso(@PathVariable Long id, @Valid @RequestBody UsoRecursosDTO dto) {
        try {
            UsoRecursosDTO updatedDto = usoRecursosService.updateUsoRecurso(id, dto);
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uso de recurso por ID", description = "Remove um registro de uso de recurso específico")
    public ResponseEntity<?> deletarUsoRecurso(@PathVariable Long id) {
        try {
            usoRecursosService.deleteUsoRecurso(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
