package br.com.projeta_api.controller;

import br.com.projeta_api.DTO.request.EmissaoDocumentoDTO;
import br.com.projeta_api.service.EmissoesDocumentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emissoes-documentos")
public class EmissoesDocumentosController {
    @Autowired
    private EmissoesDocumentosService emissoesDocumentosService;

    @GetMapping
    public ResponseEntity<EmissaoDocumentoDTO> emitirDocumento(@RequestBody EmissaoDocumentoDTO documentoDTO){
         emissoesDocumentosService.emissaoDocumento(documentoDTO);
         return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
