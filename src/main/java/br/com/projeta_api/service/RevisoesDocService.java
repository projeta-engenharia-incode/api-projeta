package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.RevisoesDocDTO;
import br.com.projeta_api.model.RevisoesDoc;
import br.com.projeta_api.repository.RevisoesDocRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevisoesDocService {

    private final RevisoesDocRepository revisoesDocRepository;

    public RevisoesDocService(RevisoesDocRepository revisoesDocRepository) {
        this.revisoesDocRepository = revisoesDocRepository;
    }

    public RevisoesDocDTO saveRevisaoDoc(RevisoesDocDTO dto) {
        try {
            RevisoesDoc entity = new RevisoesDoc();
            entity.setRevisao(dto.getRevisao());
            entity.setResponsavel(dto.getResponsavel());
            entity.setDataEnvio(dto.getDataEnvio());
            entity.setDataRespostaCiclo(dto.getDataRespostaCiclo());
            entity.setStatus(dto.getStatus());
            entity.setObservacoes(dto.getObservacoes());

            RevisoesDoc saved = revisoesDocRepository.save(entity);
            dto.setId(saved.getId());
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar revisão de documento.", e);
        }
    }

    public List<RevisoesDocDTO> listarRevisoesDocs() {
        List<RevisoesDoc> entities = revisoesDocRepository.findAll();
        if (entities.isEmpty()) {
            throw new RuntimeException("Nenhuma revisão de documento encontrada.");
        }

        return entities.stream()
                .map(doc -> new RevisoesDocDTO(
                        doc.getId(),
                        doc.getRevisao(),
                        doc.getResponsavel(),
                        doc.getDataEnvio(),
                        doc.getDataRespostaCiclo(),
                        doc.getStatus(),
                        doc.getObservacoes()
                        //doc.getRejeicoes()
                ))
                .toList();
    }

    public RevisoesDocDTO getRevisaoDocById(Long id) {
        RevisoesDoc entity = revisoesDocRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Revisão de documento não encontrada com ID: " + id));

        return new RevisoesDocDTO(
                entity.getId(),
                entity.getRevisao(),
                entity.getResponsavel(),
                entity.getDataEnvio(),
                entity.getDataRespostaCiclo(),
                entity.getStatus(),
                entity.getObservacoes()
        );
    }

    public RevisoesDocDTO updateRevisaoDoc(Long id, RevisoesDocDTO dto) {
        RevisoesDoc entity = revisoesDocRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Revisão de documento não encontrada com ID: " + id));

        entity.setRevisao(dto.getRevisao());
        entity.setResponsavel(dto.getResponsavel());
        entity.setDataEnvio(dto.getDataEnvio());
        entity.setDataRespostaCiclo(dto.getDataRespostaCiclo());
        entity.setStatus(dto.getStatus());
        entity.setObservacoes(dto.getObservacoes());

        RevisoesDoc updated = revisoesDocRepository.save(entity);
        dto.setId(updated.getId());
        return dto;
    }

    public void deleteRevisaoDoc(Long id) {
        if (!revisoesDocRepository.existsById(id)) {
            throw new RuntimeException("Revisão de documento não encontrada com ID: " + id);
        }
        revisoesDocRepository.deleteById(id);
    }
}
