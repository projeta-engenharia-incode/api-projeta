package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.EmissaoDocumentoDTO;
import br.com.projeta_api.model.Documentos;
import br.com.projeta_api.model.EmissoesDocumento;
import br.com.projeta_api.repository.DocumentosRepository;
import br.com.projeta_api.repository.EmissoesDocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmissoesDocumentosService {

    private final EmissoesDocumentoRepository emissoesDocumentoRepository;
    private final DocumentosRepository documentosRepository;

    public EmissoesDocumentosService(EmissoesDocumentoRepository emissoesDocumentoRepository,
                                     DocumentosRepository documentosRepository) {
        this.emissoesDocumentoRepository = emissoesDocumentoRepository;
        this.documentosRepository = documentosRepository;
    }

    public EmissaoDocumentoDTO saveEmissaoDocumento(EmissaoDocumentoDTO dto) {
        try {
            EmissoesDocumento entity = new EmissoesDocumento();

            Documentos documentos = documentosRepository.findById(entity.getId()).orElseThrow(() -> new RuntimeException("ERRO"));

            entity.setDocumentos(documentos);
            entity.setFase(dto.getFase());
            entity.setTipo_revisao(dto.getTipoRevisao());
            entity.setTipo_emissao(dto.getTipoEmissao());
            entity.setData_emissao(dto.getDataEmissao());
            entity.setData_entrega(dto.getDataEntrega());
            entity.setStatus_retorno(dto.getStatusRetorno());
            entity.setData_retorno(dto.getDataRetorno());
            entity.setPerc_revisao(dto.getPercRevisao());
            entity.setEquivalente_revisado(dto.getEquivalenteRevisado());
            entity.setOrdem_emissao(dto.getOrdemEmissao());
            entity.setUltima_emissao(dto.getUltimaEmissao());

            EmissoesDocumento saved = emissoesDocumentoRepository.save(entity);
            dto.setId(saved.getId());
            return dto;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar emissão de documento.", e);
        }
    }

    public List<EmissaoDocumentoDTO> listarEmissoesDocumentos() {
        List<EmissoesDocumento> entities = emissoesDocumentoRepository.findAll();
        if (entities.isEmpty()) {
            throw new RuntimeException("Nenhuma emissão de documento encontrada.");
        }

        return entities.stream()
                .map(doc -> new EmissaoDocumentoDTO(
                        doc.getId(),
                        doc.getDocumentos() != null ? doc.getDocumentos().getId() : null,
                        doc.getFase(),
                        doc.getTipo_revisao(),
                        doc.getTipo_emissao(),
                        doc.getData_emissao(),
                        doc.getData_entrega(),
                        doc.getStatus_retorno(),
                        doc.getData_retorno(),
                        doc.getPerc_revisao(),
                        doc.getEquivalente_revisado(),
                        doc.getOrdem_emissao(),
                        doc.getUltima_emissao()
                ))
                .toList();
    }

    public EmissaoDocumentoDTO getEmissaoDocumentoById(Long id) {
        EmissoesDocumento entity = emissoesDocumentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emissão de documento não encontrada com ID: " + id));

        return new EmissaoDocumentoDTO(
                entity.getId(),
                entity.getDocumentos() != null ? entity.getDocumentos().getId() : null,
                entity.getFase(),
                entity.getTipo_revisao(),
                entity.getTipo_emissao(),
                entity.getData_emissao(),
                entity.getData_entrega(),
                entity.getStatus_retorno(),
                entity.getData_retorno(),
                entity.getPerc_revisao(),
                entity.getEquivalente_revisado(),
                entity.getOrdem_emissao(),
                entity.getUltima_emissao()
        );
    }

    public EmissaoDocumentoDTO updateEmissaoDocumento(Long id, EmissaoDocumentoDTO dto) {
        EmissoesDocumento entity = emissoesDocumentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emissão de documento não encontrada com ID: " + id));

        if (dto.getDocumentoId() != null) {
            Documentos doc = documentosRepository.findById(dto.getDocumentoId())
                    .orElseThrow(() -> new RuntimeException("Documento não encontrado com ID: " + dto.getDocumentoId()));
            entity.setDocumentos(doc);
        }

        entity.setFase(dto.getFase());
        entity.setTipo_revisao(dto.getTipoRevisao());
        entity.setTipo_emissao(dto.getTipoEmissao());
        entity.setData_emissao(dto.getDataEmissao());
        entity.setData_entrega(dto.getDataEntrega());
        entity.setStatus_retorno(dto.getStatusRetorno());
        entity.setData_retorno(dto.getDataRetorno());
        entity.setPerc_revisao(dto.getPercRevisao());
        entity.setEquivalente_revisado(dto.getEquivalenteRevisado());
        entity.setOrdem_emissao(dto.getOrdemEmissao());
        entity.setUltima_emissao(dto.getUltimaEmissao());

        EmissoesDocumento updated = emissoesDocumentoRepository.save(entity);
        dto.setId(updated.getId());
        return dto;
    }

    public void deleteEmissaoDocumento(Long id) {
        if (!emissoesDocumentoRepository.existsById(id)) {
            throw new RuntimeException("Emissão de documento não encontrada com ID: " + id);
        }
        emissoesDocumentoRepository.deleteById(id);
    }
}
