package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.AprovacoesCicloDTO;
import br.com.projeta_api.model.AprovacoesCiclo;
import br.com.projeta_api.repository.AprovacoesCicloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AprovacoesCicloService {

    private final AprovacoesCicloRepository aprovacoesCicloRepository;


    public AprovacoesCicloService(AprovacoesCicloRepository aprovacoesCicloRepository) {
        this.aprovacoesCicloRepository = aprovacoesCicloRepository;
    }

    public AprovacoesCicloDTO saveAprovacaoCiclo(AprovacoesCicloDTO dto) {
        try {
            AprovacoesCiclo entity = new AprovacoesCiclo();
            entity.setDocumento_id(dto.getDocumento_id());
            entity.setCiclo_id(dto.getCiclo_id());
            entity.setData_aprovacao(dto.getData_aprovacao());
            entity.setAutorizado_por(dto.getAutorizado_por());
            entity.setStatus_aprovacao(dto.getStatus_aprovacao());
            entity.setObservacoes(dto.getObservacoes());

            AprovacoesCiclo savedEntity = aprovacoesCicloRepository.save(entity);
            dto.setId(savedEntity.getId());
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar aprovação de ciclo.", e);
        }
    }

    public List<AprovacoesCicloDTO> listarAprovacoesCiclos() {
        List<AprovacoesCiclo> entities = aprovacoesCicloRepository.findAll();
        if (entities.isEmpty()) {
            throw new RuntimeException("Nenhuma aprovação de ciclo encontrada.");
        }
        return entities.stream()
                .map(ciclo -> new AprovacoesCicloDTO(
                        ciclo.getId(),
                        ciclo.getDocumento_id(),
                        ciclo.getCiclo_id(),
                        ciclo.getData_aprovacao(),
                        ciclo.getAutorizado_por(),
                        ciclo.getStatus_aprovacao(),
                        ciclo.getObservacoes()
                ))
                .toList();
    }

    public AprovacoesCicloDTO getAprovacaoCicloById(Long id) {
        AprovacoesCiclo entity = aprovacoesCicloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aprovação de ciclo não encontrada com ID: " + id));

        return new AprovacoesCicloDTO(
                entity.getId(),
                entity.getDocumento_id(),
                entity.getCiclo_id(),
                entity.getData_aprovacao(),
                entity.getAutorizado_por(),
                entity.getStatus_aprovacao(),
                entity.getObservacoes()
        );
    }

    public AprovacoesCicloDTO updateAprovacaoCiclo(Long id, AprovacoesCicloDTO dto) {
        AprovacoesCiclo entity = aprovacoesCicloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aprovação de ciclo não encontrada com ID: " + id));

        entity.setDocumento_id(dto.getDocumento_id());
        entity.setCiclo_id(dto.getCiclo_id());
        entity.setData_aprovacao(dto.getData_aprovacao());
        entity.setAutorizado_por(dto.getAutorizado_por());
        entity.setStatus_aprovacao(dto.getStatus_aprovacao());
        entity.setObservacoes(dto.getObservacoes());

        AprovacoesCiclo updated = aprovacoesCicloRepository.save(entity);
        dto.setId(updated.getId());
        return dto;
    }

    public void deleteAprovacaoCiclo(Long id) {
        if (!aprovacoesCicloRepository.existsById(id)) {
            throw new RuntimeException("Aprovação de ciclo não encontrada com ID: " + id);
        }
        aprovacoesCicloRepository.deleteById(id);
    }
}
