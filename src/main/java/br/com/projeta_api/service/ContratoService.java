package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.ContratoDTO;
import br.com.projeta_api.model.Contrato;
import br.com.projeta_api.model.PreContrato;
import br.com.projeta_api.repository.ContratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratoService {
    private final ContratoRepository contratoRepository;

    public ContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    public ContratoDTO saveContrato(ContratoDTO dto) {
        try {
            Contrato entity = new Contrato();
            entity.setCodigo(dto.getCodigo());
            entity.setContrato(dto.getContrato());
            entity.setSubcontrato(dto.getSubcontrato());
            entity.setEmpresa(dto.getEmpresa());
            entity.setGestor(dto.getGestor());
            entity.setDataInicio(dto.getDataInicio());
            entity.setDataFim(dto.getDataFim());
            entity.setValorTotal(dto.getValorTotal());
            entity.setRevisao(dto.getRevisao());

//            // Caso preContratoId seja fornecido, criar referência
//            if (dto.getPreContratoId() != null) {
//                PreContrato preContrato = new PreContrato();
//                preContrato.setId(dto.getPreContratoId());
//                entity.setPreContrato(preContrato);
//            }

            entity.setCreatedAt(dto.getCreatedAt());
            entity.setUpdatedAt(dto.getUpdatedAt());

            Contrato saved = contratoRepository.save(entity);
            dto.setId(saved.getId());
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar contrato.", e);
        }
    }

    public List<ContratoDTO> listarContratos() {
        List<Contrato> entities = contratoRepository.findAll();
        if (entities.isEmpty()) {
            throw new RuntimeException("Nenhum contrato encontrado.");
        }

        return entities.stream()
                .map(c -> new ContratoDTO(
                        c.getId(),
                        c.getCodigo(),
                        c.getContrato(),
                        c.getSubcontrato(),
                        c.getEmpresa(),
                        c.getGestor(),
                        c.getDataInicio(),
                        c.getDataFim(),
                        c.getValorTotal(),
                        c.getRevisao(),
                        c.getPreContrato() != null ? c.getPreContrato().getId() : null,
                        c.getCreatedAt(),
                        c.getUpdatedAt()
                ))
                .toList();
    }

    public ContratoDTO getContratoById(Long id) {
        Contrato entity = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato não encontrado com ID: " + id));

        return new ContratoDTO(
                entity.getId(),
                entity.getCodigo(),
                entity.getContrato(),
                entity.getSubcontrato(),
                entity.getEmpresa(),
                entity.getGestor(),
                entity.getDataInicio(),
                entity.getDataFim(),
                entity.getValorTotal(),
                entity.getRevisao(),
                entity.getPreContrato() != null ? entity.getPreContrato().getId() : null,
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public ContratoDTO updateContrato(Long id, ContratoDTO dto) {
        Contrato entity = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato não encontrado com ID: " + id));

        entity.setCodigo(dto.getCodigo());
        entity.setContrato(dto.getContrato());
        entity.setSubcontrato(dto.getSubcontrato());
        entity.setEmpresa(dto.getEmpresa());
        entity.setGestor(dto.getGestor());
        entity.setDataInicio(dto.getDataInicio());
        entity.setDataFim(dto.getDataFim());
        entity.setValorTotal(dto.getValorTotal());
        entity.setRevisao(dto.getRevisao());

        if (dto.getPreContratoId() != null) {
            PreContrato preContrato = new PreContrato();
            preContrato.setId(dto.getPreContratoId());
            entity.setPreContrato(preContrato);
        } else {
            entity.setPreContrato(null);
        }

        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());

        Contrato updated = contratoRepository.save(entity);
        dto.setId(updated.getId());
        return dto;
    }

    public void deleteContrato(Long id) {
        if (!contratoRepository.existsById(id)) {
            throw new RuntimeException("Contrato não encontrado com ID: " + id);
        }
        contratoRepository.deleteById(id);
    }
}
