package br.com.projeta_api.controller;


import br.com.projeta_api.DTO.request.RejeicoesRevisaoDTO;
import br.com.projeta_api.model.RejeicoesRevisao;
import br.com.projeta_api.service.RejeicoesRevisaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rejeicoes-revisao")
@Tag(name = "Rejeições de Revisão", description = "Endpoints para gerenciar rejeições de revisão")
public class RejeicoesRevisaoController {


    private final RejeicoesRevisaoService rejeicoesRevisaoService;

    public RejeicoesRevisaoController(RejeicoesRevisaoService rejeicoesRevisaoService) {
        this.rejeicoesRevisaoService = rejeicoesRevisaoService;
    }

    @GetMapping
    @Operation(summary = "Lista todas as rejeições de revisão", description = "Retorna todas as rejeições de revisão cadastradas")
    public ResponseEntity<?> listarRejeicoes() {
        try {
            return new ResponseEntity<>(rejeicoesRevisaoService.getAllRejeicoesRevisao(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @Operation(summary = "Cria uma rejeição de revisão", description = "Cria uma nova rejeição de revisão e retorna os dados criados")
    public ResponseEntity<?> criarRejeicao(@Valid @RequestBody RejeicoesRevisaoDTO dto) {
        try {
            RejeicoesRevisaoDTO createdDto = rejeicoesRevisaoService.saveRejeicaoRevisao(dto);
            return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca rejeição de revisão por ID", description = "Retorna os dados de uma rejeição de revisão específica")
    public ResponseEntity<?> rejeicaoPorId(@PathVariable Long id) {
        try {
            RejeicoesRevisao entity = rejeicoesRevisaoService.getRejeicaoRevisaoById(id);
            return new ResponseEntity<>(entity, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza rejeição de revisão por ID", description = "Atualiza os dados de uma rejeição de revisão específica")
    public ResponseEntity<?> atualizarRejeicao(@PathVariable Long id, @Valid @RequestBody RejeicoesRevisaoDTO dto) {
        try {
            dto.setId(id);
            RejeicoesRevisaoDTO updatedDto = rejeicoesRevisaoService.updateRejeicaoRevisao(dto);
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta rejeição de revisão por ID", description = "Remove uma rejeição de revisão específica")
    public ResponseEntity<?> deletarRejeicao(@PathVariable Long id) {
        try {
            rejeicoesRevisaoService.deleteRejeicaoRevisao(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
