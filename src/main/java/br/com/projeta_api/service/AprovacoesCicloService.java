package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.AprovacoesCicloDTO;
import br.com.projeta_api.model.AprovacoesCiclo;
import br.com.projeta_api.model.Ciclo;
import br.com.projeta_api.model.Documentos;
import br.com.projeta_api.repository.AprovacoesCicloRepository;
import br.com.projeta_api.repository.CicloRepository;
import br.com.projeta_api.repository.DocumentosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AprovacoesCicloService {

    private final AprovacoesCicloRepository aprovacoesCicloRepository;

    private final DocumentosRepository  documentosRepository;

    private final CicloRepository cicloRepository;


    public AprovacoesCicloService(AprovacoesCicloRepository aprovacoesCicloRepository,  DocumentosRepository  documentosRepository, CicloRepository cicloRepository) {
        this.aprovacoesCicloRepository = aprovacoesCicloRepository;
        this.documentosRepository = documentosRepository;
        this.cicloRepository = cicloRepository;
    }

    public AprovacoesCicloDTO saveAprovacaoCiclo(AprovacoesCicloDTO dto) {
        try {
            AprovacoesCiclo entity = new AprovacoesCiclo();

            Documentos doc = documentosRepository.findById(entity.getDocumentos().getId()).orElseThrow(() -> new RuntimeException("ERRO"));
            Ciclo ciclo =  cicloRepository.findById(entity.getCiclo().getId()).orElseThrow(() -> new RuntimeException("ERRO"));
            entity.setDocumentos(doc);
            entity.setCiclo(ciclo);
            entity.setData_aprovacao(dto.getDataAprovacao());
            entity.setAutorizado_por(dto.getAutorizadoPor());
            entity.setStatus_aprovacao(dto.getStatusAprovacao());
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
                        ciclo.getDocumentos().getId(),
                        ciclo.getCiclo().getId(),
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
                entity.getDocumentos().getId(),
                entity.getCiclo().getId(),
                entity.getData_aprovacao(),
                entity.getAutorizado_por(),
                entity.getStatus_aprovacao(),
                entity.getObservacoes()
        );
    }

    public AprovacoesCicloDTO updateAprovacaoCiclo(Long id, AprovacoesCicloDTO dto) {
        AprovacoesCiclo entity = aprovacoesCicloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aprovação de ciclo não encontrada com ID: " + id));

        Documentos docUp = documentosRepository.findById(entity.getDocumentos().getId()).orElseThrow(() -> new RuntimeException("ERRO"));
        Ciclo cicloUp =  cicloRepository.findById(entity.getCiclo().getId()).orElseThrow(() -> new RuntimeException("ERRO"));

        entity.setDocumentos(docUp);
        entity.setCiclo(cicloUp);
        entity.setData_aprovacao(dto.getDataAprovacao());
        entity.setAutorizado_por(dto.getAutorizadoPor());
        entity.setStatus_aprovacao(dto.getStatusAprovacao());
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
