package br.com.projeta_api.controller;


import br.com.projeta_api.DTO.request.PagamentosFornecedoresDTO;
import br.com.projeta_api.service.PagamentosFornecedoresService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamentos-fornecedores")
@Tag(name = "Pagamentos de Fornecedores", description = "Endpoints para gerenciar pagamentos de fornecedores")
public class PagamentosFornecedoresController {

    private final PagamentosFornecedoresService pagamentosService;

    public PagamentosFornecedoresController(PagamentosFornecedoresService pagamentosService) {
        this.pagamentosService = pagamentosService;
    }

    @GetMapping
    @Operation(summary = "Lista todos os pagamentos", description = "Retorna todos os pagamentos de fornecedores")
    public ResponseEntity<?> listarPagamentos() {
        try {
            return new ResponseEntity<>(pagamentosService.listarPagamentosFornecedores(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @Operation(summary = "Cria um pagamento", description = "Cria um pagamento de fornecedor e retorna os dados criados")
    public ResponseEntity<?> criarPagamento(@Valid @RequestBody PagamentosFornecedoresDTO dto) {
        try {
            PagamentosFornecedoresDTO createdDto = pagamentosService.savePagamentoFornecedor(dto);
            return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca pagamento por ID", description = "Retorna os dados de um pagamento de fornecedor específico")
    public ResponseEntity<?> pagamentoPorId(@PathVariable Long id) {
        try {
            PagamentosFornecedoresDTO dto = pagamentosService.getPagamentoFornecedorById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza pagamento por ID", description = "Atualiza os dados de um pagamento de fornecedor")
    public ResponseEntity<?> atualizarPagamento(@PathVariable Long id, @Valid @RequestBody PagamentosFornecedoresDTO dto) {
        try {
            PagamentosFornecedoresDTO updatedDto = pagamentosService.updatePagamentoFornecedor(id, dto);
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta pagamento por ID", description = "Remove um pagamento de fornecedor específico")
    public ResponseEntity<?> deletarPagamento(@PathVariable Long id) {
        try {
            pagamentosService.deletePagamentoFornecedor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
