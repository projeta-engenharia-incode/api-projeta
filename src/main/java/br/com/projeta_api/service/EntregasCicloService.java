package br.com.projeta_api.service;

import br.com.projeta_api.dto.EntregasCicloDTO;
import br.com.projeta_api.model.Ciclo;
import br.com.projeta_api.model.Documentos;
import br.com.projeta_api.model.EntregasCiclo;
import br.com.projeta_api.repository.CicloRepository;
import br.com.projeta_api.repository.DocumentosRepository;
import br.com.projeta_api.repository.EntregasCicloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregasCicloService {

    private final EntregasCicloRepository entregasCicloRepository;

    private final DocumentosRepository documentosRepository;

    private final CicloRepository cicloRepository;

    public EntregasCicloService(EntregasCicloRepository entregasCicloRepository, DocumentosRepository documentosRepository, CicloRepository cicloRepository) {
        this.entregasCicloRepository = entregasCicloRepository;
        this.documentosRepository = documentosRepository;
        this.cicloRepository = cicloRepository;
    }

    public List<EntregasCiclo> getAllEntregas() {
        List<EntregasCiclo> entregas = entregasCicloRepository.findAll();
        if (entregas.isEmpty()) {
            throw new RuntimeException("Nenhuma entrega de ciclo encontrada.");
        }
        return entregas;
    }

    public EntregasCicloDTO saveEntrega(EntregasCicloDTO dto) {
        try {
            EntregasCiclo entity = new EntregasCiclo();

            Documentos doc = documentosRepository.findById(entity.getDocumento().getId()).orElseThrow(() -> new RuntimeException("Nenhum documento encontrado."));

            Ciclo ciclo = cicloRepository.findById(entity.getCiclo().getId()).orElseThrow(() -> new RuntimeException("Nenhum documento encontrado."));
            entity.setDocumento(doc);
            entity.setCiclo(ciclo);
            entity.setDataEntrega(dto.getDataEntrega());
            entity.setPercentualCobrado(dto.getPercentualCobrado());
            entity.setValorCobrado(dto.getValorCobrado());
            entity.setStatusCobranca(dto.getStatusCobranca());

            EntregasCiclo savedEntity = entregasCicloRepository.save(entity);
            dto.setId(savedEntity.getId());
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar entrega do ciclo.", e);
        }
    }

    public EntregasCicloDTO updateEntrega(EntregasCicloDTO dto) {
        try {
            EntregasCiclo entity = entregasCicloRepository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("Entrega do ciclo não encontrada com o ID: " + dto.getId()));

            Documentos docUp = documentosRepository.findById(entity.getDocumento().getId()).orElseThrow(() -> new RuntimeException("Nenhum documento encontrado."));

            Ciclo cicloUp = cicloRepository.findById(entity.getCiclo().getId()).orElseThrow(() -> new RuntimeException("Nenhum documento encontrado."));

            entity.setDocumento(docUp);
            entity.setCiclo(cicloUp);
            entity.setDataEntrega(dto.getDataEntrega());
            entity.setPercentualCobrado(dto.getPercentualCobrado());
            entity.setValorCobrado(dto.getValorCobrado());
            entity.setStatusCobranca(dto.getStatusCobranca());

            entregasCicloRepository.save(entity);
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar entrega do ciclo.", e);
        }
    }

    public EntregasCiclo getEntregaById(Long id) {
        return entregasCicloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrega do ciclo não encontrada com o ID: " + id));
    }

    public void deleteEntrega(Long id) {
        if (!entregasCicloRepository.existsById(id)) {
            throw new RuntimeException("Entrega do ciclo não encontrada com o ID: " + id);
        }
        entregasCicloRepository.deleteById(id);
    }

    public boolean existeEntregaPorId(Long id) {
        return entregasCicloRepository.existsById(id);
    }
}
