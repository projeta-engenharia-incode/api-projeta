package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.AprovacoesClientesDTO;
import br.com.projeta_api.model.AprovacoesClientes;
import br.com.projeta_api.model.Ciclo;
import br.com.projeta_api.model.Documentos;
import br.com.projeta_api.repository.AprovacoesClientesRepository;
import br.com.projeta_api.repository.CicloRepository;
import br.com.projeta_api.repository.DocumentosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AprovacoesClientesService {

    private final AprovacoesClientesRepository aprovacoesClientesRepository;

    private final DocumentosRepository  documentosRepository;

    private final CicloRepository cicloRepository;


    public AprovacoesClientesService(AprovacoesClientesRepository aprovacoesClientesRepository, DocumentosRepository  documentosRepository, CicloRepository cicloRepository) {
        this.aprovacoesClientesRepository = aprovacoesClientesRepository;
        this.documentosRepository = documentosRepository;
        this.cicloRepository = cicloRepository;
    }

    public AprovacoesClientesDTO saveAprovacaoCiclo(AprovacoesClientesDTO dto) {
        try {
            AprovacoesClientes entity = new AprovacoesClientes();

            Documentos doc = documentosRepository.findById(dto.getDocumentoId()).orElseThrow(() -> new RuntimeException("ERRO"));
            Ciclo ciclo =  cicloRepository.findById(dto.getCicloId()).orElseThrow(() -> new RuntimeException("ERRO"));
            entity.setDocumentos(doc);
            entity.setCiclo(ciclo);
            entity.setData_aprovacao(dto.getDataAprovacao());
            entity.setOrigem(dto.getOrigem());
            entity.setAutorizado_por(dto.getAutorizadoPor());
            entity.setStatus_aprovacao(dto.getStatusAprovacao());
            entity.setObservacoes(dto.getObservacoes());

            AprovacoesClientes savedEntity = aprovacoesClientesRepository.save(entity);
            dto.setId(savedEntity.getId());
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar aprovação de ciclo." + e.getMessage());
        }
    }

    public List<AprovacoesClientesDTO> listarAprovacoesCiclos() {
        List<AprovacoesClientes> entities = aprovacoesClientesRepository.findAll();
        if (entities.isEmpty()) {
            throw new RuntimeException("Nenhuma aprovação de ciclo encontrada.");
        }
        return entities.stream()
                .map(ciclo -> new AprovacoesClientesDTO(
                        ciclo.getId(),
                        ciclo.getDocumentos().getId(),
                        ciclo.getCiclo().getId(),
                        ciclo.getData_aprovacao(),
                        ciclo.getOrigem(),
                        ciclo.getAutorizado_por(),
                        ciclo.getStatus_aprovacao(),
                        ciclo.getObservacoes()
                ))
                .toList();
    }

    public AprovacoesClientesDTO getAprovacaoCicloById(Long id) {
        AprovacoesClientes entity = aprovacoesClientesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aprovação de ciclo não encontrada com ID: " + id));

        return new AprovacoesClientesDTO(
                entity.getId(),
                entity.getDocumentos().getId(),
                entity.getCiclo().getId(),
                entity.getData_aprovacao(),
                entity.getOrigem(),
                entity.getAutorizado_por(),
                entity.getStatus_aprovacao(),
                entity.getObservacoes()
        );
    }

    public AprovacoesClientesDTO updateAprovacaoCiclo(Long id, AprovacoesClientesDTO dto) {
        AprovacoesClientes entity = aprovacoesClientesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aprovação de ciclo não encontrada com ID: " + id));

        Documentos docUp = documentosRepository.findById(entity.getDocumentos().getId()).orElseThrow(() -> new RuntimeException("ERRO"));
        Ciclo cicloUp =  cicloRepository.findById(entity.getCiclo().getId()).orElseThrow(() -> new RuntimeException("ERRO"));

        entity.setDocumentos(docUp);
        entity.setCiclo(cicloUp);
        entity.setData_aprovacao(dto.getDataAprovacao());
        entity.setAutorizado_por(dto.getAutorizadoPor());
        entity.setOrigem(dto.getOrigem());
        entity.setStatus_aprovacao(dto.getStatusAprovacao());
        entity.setObservacoes(dto.getObservacoes());

        AprovacoesClientes updated = aprovacoesClientesRepository.save(entity);
        dto.setId(updated.getId());
        return dto;
    }

    public void deleteAprovacaoCiclo(Long id) {
        if (!aprovacoesClientesRepository.existsById(id)) {
            throw new RuntimeException("Aprovação de ciclo não encontrada com ID: " + id);
        }
        aprovacoesClientesRepository.deleteById(id);
    }
}
