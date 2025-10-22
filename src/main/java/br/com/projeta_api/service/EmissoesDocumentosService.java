package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.EmissaoDocumentoDTO;
import br.com.projeta_api.model.EmissoesDocumento;
import br.com.projeta_api.repository.EmissoesDocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmissoesDocumentosService {

    private final EmissoesDocumentoRepository emissoesDocumentoRepository;

    public EmissoesDocumentosService(EmissoesDocumentoRepository emissoesDocumentoRepository) {
        this.emissoesDocumentoRepository = emissoesDocumentoRepository;
    }

    public EmissaoDocumentoDTO criarEmissaoDocumento(EmissaoDocumentoDTO dto) {
        try {
            EmissoesDocumento entity = new EmissoesDocumento();
            entity.setDocumento_id(dto.getDocumento_id());
            entity.setFase(dto.getFase());
            entity.setTipo_revisao(dto.getTipo_revisao());
            entity.setTipo_emissao(dto.getTipo_emissao());
            entity.setData_emissao(dto.getData_emissao());
            entity.setData_entrega(dto.getData_entrega());
            entity.setStatus_retorno(dto.getStatus_retorno());
            entity.setData_retorno(dto.getData_retorno());
            entity.setPerc_revisao(dto.getPerc_revisao());
            entity.setEquivalente_revisado(dto.getEquivalente_revisado());
            entity.setOrdem_emissao(dto.getOrdem_emissao());
            entity.setUltima_emissao(dto.getUltima_emissao());

            EmissoesDocumento saved = emissoesDocumentoRepository.save(entity);
            dto.setDocumento_id(saved.getDocumento_id());
            return dto;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar emissão de documento.", e);
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
                        doc.getDocumento_id(),
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

    public EmissaoDocumentoDTO emissaoDocumentoPorId(Long documento_id) {
        EmissoesDocumento entity = emissoesDocumentoRepository.findById(documento_id)
                .orElseThrow(() -> new RuntimeException("Emissão de documento não encontrada com o ID: " + documento_id));

        return new EmissaoDocumentoDTO(
                entity.getId(),
                entity.getDocumento_id(),
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

    public EmissaoDocumentoDTO atualizarEmissaoDocumento(Long documento_id, EmissaoDocumentoDTO dto) {
        try {
            EmissoesDocumento entity = emissoesDocumentoRepository.findById(documento_id)
                    .orElseThrow(() -> new RuntimeException("Emissão de documento não encontrada com o ID: " + documento_id));

            entity.setFase(dto.getFase());
            entity.setTipo_revisao(dto.getTipo_revisao());
            entity.setTipo_emissao(dto.getTipo_emissao());
            entity.setData_emissao(dto.getData_emissao());
            entity.setData_entrega(dto.getData_entrega());
            entity.setStatus_retorno(dto.getStatus_retorno());
            entity.setData_retorno(dto.getData_retorno());
            entity.setPerc_revisao(dto.getPerc_revisao());
            entity.setEquivalente_revisado(dto.getEquivalente_revisado());
            entity.setOrdem_emissao(dto.getOrdem_emissao());
            entity.setUltima_emissao(dto.getUltima_emissao());

            EmissoesDocumento updated = emissoesDocumentoRepository.save(entity);
            dto.setDocumento_id(updated.getDocumento_id());
            return dto;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar emissão de documento.", e);
        }
    }

    public void deletarEmissaoDocumento(Long documento_id) {
        if (!emissoesDocumentoRepository.existsById(documento_id)) {
            throw new RuntimeException("Emissão de documento não encontrada com o ID: " + documento_id);
        }
        emissoesDocumentoRepository.deleteById(documento_id);
    }
}
