package br.com.projeta_api.controller;


import br.com.projeta_api.dto.MedicoesDocumentosDTO;
import br.com.projeta_api.model.MedicoesDocumentos;
import br.com.projeta_api.service.MedicoesDocumentosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicoes")
@Tag(name = "Medições de Documentos", description = "Endpoints para gerenciar medições de documentos")
public class MedicoesDocumentosController {

    private final MedicoesDocumentosService medicoesService;

    public MedicoesDocumentosController(MedicoesDocumentosService medicoesService) {
        this.medicoesService = medicoesService;
    }

    @GetMapping
    @Operation(summary = "Lista todas as medições", description = "Retorna uma lista de todas as medições de documentos")
    public ResponseEntity<?> listarMedicoes() {
        try {
            return new ResponseEntity<>(medicoesService.getAllMedicoes(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @Operation(summary = "Cria uma nova medição", description = "Cria uma medição de documento e retorna os dados criados")
    public ResponseEntity<?> criarMedicao(@Valid @RequestBody MedicoesDocumentosDTO dto) {
        try {
            MedicoesDocumentosDTO createdDto = medicoesService.saveMedicao(dto);
            return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma medição pelo ID", description = "Retorna os detalhes de uma medição específica")
    public ResponseEntity<?> medicaoPorId(@PathVariable Long id) {
        try {
            MedicoesDocumentos entity = medicoesService.getMedicaoById(id);
            return new ResponseEntity<>(entity, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma medição pelo ID", description = "Atualiza os dados de uma medição existente")
    public ResponseEntity<?> atualizarMedicao(@PathVariable Long id, @Valid @RequestBody MedicoesDocumentosDTO dto) {
        try {
            dto.setId(id);
            MedicoesDocumentosDTO updatedDto = medicoesService.updateMedicao(dto);
            return new ResponseEntity<>(updatedDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma medição pelo ID", description = "Remove uma medição específica")
    public ResponseEntity<?> deletarMedicao(@PathVariable Long id) {
        try {
            medicoesService.deleteMedicao(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
