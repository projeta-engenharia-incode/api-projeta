package br.com.projeta_api.controller;


import br.com.projeta_api.dto.CicloDTO;
import br.com.projeta_api.service.CicloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ciclo")
@Tag(name = "Ciclos", description = "Endpoints para gerenciar ciclos")
public class CicloController {


    private final CicloService cicloService;

    public CicloController(CicloService cicloService) {
        this.cicloService = cicloService;
    }

    @GetMapping
    @Operation(summary = "Lista todos os ciclos", description = "Retorna uma lista de todos os ciclos cadastrados")
    public ResponseEntity<?> listarCiclos() {
        try {
            return new ResponseEntity<>(cicloService.listar(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @Operation(summary = "Cria um novo ciclo", description = "Cria um ciclo e retorna os dados do ciclo criado")
    public ResponseEntity<?> criarCiclo(@Valid @RequestBody CicloDTO dto) {
        try {
            CicloDTO createdDto = cicloService.criar(dto);
            return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um ciclo pelo ID", description = "Retorna os detalhes de um ciclo específico")
    public ResponseEntity<?> buscarCicloPorId(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(cicloService.buscarPorId(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um ciclo pelo ID", description = "Atualiza as informações de um ciclo existente")
    public ResponseEntity<?> atualizarCiclo(@PathVariable Long id, @Valid @RequestBody CicloDTO dto) {
        try {
            CicloDTO updatedDto = cicloService.atualizar(id, dto);
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um ciclo pelo ID", description = "Remove um ciclo específico")
    public ResponseEntity<?> deletarCiclo(@PathVariable Long id) {
        try {
            cicloService.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
