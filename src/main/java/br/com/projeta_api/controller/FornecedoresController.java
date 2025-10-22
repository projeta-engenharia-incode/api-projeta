package br.com.projeta_api.controller;


import br.com.projeta_api.DTO.request.FornecedoresDTO;
import br.com.projeta_api.service.FornecedoresService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fornecedores")
@Tag(name = "Fornecedores", description = "Endpoints para gerenciar fornecedores")
public class FornecedoresController {


    private final FornecedoresService fornecedoresService;

    public FornecedoresController(FornecedoresService fornecedoresService) {
        this.fornecedoresService = fornecedoresService;
    }

    @GetMapping
    @Operation(summary = "Lista todos os fornecedores", description = "Retorna uma lista de todos os fornecedores")
    public ResponseEntity<?> listarFornecedores() {
        try {
            return new ResponseEntity<>(fornecedoresService.listarFornecedores().toList(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @Operation(summary = "Cria um novo fornecedor", description = "Cria um fornecedor e retorna os dados criados")
    public ResponseEntity<?> criarFornecedor(@Valid @RequestBody FornecedoresDTO dto) {
        try {
            FornecedoresDTO createdDto = fornecedoresService.criarFornecedor(dto);
            return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um fornecedor pelo ID", description = "Retorna os detalhes de um fornecedor específico")
    public ResponseEntity<?> fornecedorPorId(@PathVariable Long id) {
        try {
            FornecedoresDTO dto = fornecedoresService.fornecedorPorId(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um fornecedor pelo ID", description = "Atualiza os dados de um fornecedor existente")
    public ResponseEntity<?> atualizarFornecedor(@PathVariable Long id, @Valid @RequestBody FornecedoresDTO dto) {
        try {
            FornecedoresDTO updatedDto = fornecedoresService.atualizarFornecedor(id, dto);
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um fornecedor pelo ID", description = "Remove um fornecedor específico")
    public ResponseEntity<?> deletarFornecedor(@PathVariable Long id) {
        try {
            fornecedoresService.deletarFornecedor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
