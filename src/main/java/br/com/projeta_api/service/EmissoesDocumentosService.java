package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.EmissaoDocumentoDTO;
import br.com.projeta_api.model.EmissoesDocumento;
import br.com.projeta_api.repository.EmissoesDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class EmissoesDocumentosService {
    @Autowired
    private EmissoesDocumentoRepository emissoesDocumentoRepository;

    public EmissaoDocumentoDTO emissaoDocumento(EmissaoDocumentoDTO documentoDTO){
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
        emissoesDocumentoRepository.save(documento);
        return documentoDTO;
    }
    public Stream<EmissaoDocumentoDTO> ListaEmissoesDocumentos(){
        List<EmissoesDocumento> entity = emissoesDocumentoRepository.findAll();
        return entity.stream().map( emissoesDocumentos -> new EmissaoDocumentoDTO(
                emissoesDocumentos.getDocumento_id(), emissoesDocumentos.getFase(), emissoesDocumentos.getTipo_revisao(), emissoesDocumentos.getTipo_emissao(),
                emissoesDocumentos.getData_emissao(), emissoesDocumentos.getData_entrega(), emissoesDocumentos.getStatus_retorno(),
                emissoesDocumentos.getData_retorno(), emissoesDocumentos.getPerc_revisao(), emissoesDocumentos.getPerc_revisao(),
                emissoesDocumentos.getOrdem_emissao(), emissoesDocumentos.getUltima_emissao()
                )
        );
    }

    public EmissaoDocumentoDTO emissaoDocumentosPorId(Long documento_id){
        EmissoesDocumento entity = emissoesDocumentoRepository.findById(documento_id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        return new EmissaoDocumentoDTO(
                entity.getDocumento_id(), entity.getFase(), entity.getTipo_revisao(), entity.getTipo_emissao(),
                entity.getData_emissao(), entity.getData_entrega(), entity.getStatus_retorno(), entity.getData_retorno(),
                entity.getPerc_revisao(), entity.getEquivalente_revisado(), entity.getOrdem_emissao(), entity.getUltima_emissao()
        );
    }
    public void atualizarEmissaoDocumento(Long documento_id, EmissaoDocumentoDTO documentoDTO){
        EmissoesDocumento entity = emissoesDocumentoRepository.findById(documento_id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        entity.setFase(documentoDTO.getFase());
        entity.setTipo_revisao(documentoDTO.getTipo_revisao());
        entity.setTipo_emissao(documentoDTO.getTipo_emissao());
        entity.setData_emissao(documentoDTO.getData_emissao());
        entity.setData_entrega(documentoDTO.getData_entrega());
        entity.setStatus_retorno(documentoDTO.getStatus_retorno());
        entity.setData_retorno(documentoDTO.getData_retorno());
        entity.setPerc_revisao(documentoDTO.getPerc_revisao());
        entity.setEquivalente_revisado(documentoDTO.getEquivalente_revisado());
        entity.setOrdem_emissao(documentoDTO.getOrdem_emissao());
        entity.setUltima_emissao(documentoDTO.getUltima_emissao());
        emissoesDocumentoRepository.save(entity);
    }
    public void deletarEmissaoDocumento(Long documento_id){
        emissoesDocumentoRepository.findById(documento_id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        emissoesDocumentoRepository.deleteById(documento_id);
    }
}
