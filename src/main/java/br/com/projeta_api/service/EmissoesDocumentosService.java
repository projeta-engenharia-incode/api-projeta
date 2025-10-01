package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.EmitirDocumentoDTO;
import br.com.projeta_api.model.EmissoesDocumento;
import br.com.projeta_api.repository.EmissoesDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmissoesDocumentosService {
    @Autowired
    private EmissoesDocumentoRepository documentoRepository;

    public EmitirDocumentoDTO emitirDocumento(EmitirDocumentoDTO documentoDTO){
        EmissoesDocumento documento = new EmissoesDocumento();
        documento.setDocumento_id(documentoDTO.getDocumento_id());
        documento.setFase(documentoDTO.getFase());
        documento.setTipo_revisao(documentoDTO.getTipo_revisao());
        documento.setTipo_emissao(documentoDTO.getTipo_emissao());
        documento.setData_emissao(documento.getData_emissao());
        documento.setData_entrega(documentoDTO.getData_entrega());
        documento.setStatus_retorno(documentoDTO.getStatus_retorno());
        documento.setData_retorno(documentoDTO.getData_retorno());
        documento.setPerc_revisao(documentoDTO.getPerc_revisao());
        documento.setEquivalente_revisado(documentoDTO.getEquivalente_revisado());
        documento.setOrdem_emissao(documentoDTO.getOrdem_emissao());
        documento.setUltima_emissao(documentoDTO.getUltima_emissao());
        documentoRepository.save(documento);
        return documentoDTO;
    }
}
