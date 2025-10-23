package br.com.projeta_api.service;

import br.com.projeta_api.dto.MedicoesDocumentosDTO;
import br.com.projeta_api.model.Ciclo;
import br.com.projeta_api.model.Documentos;
import br.com.projeta_api.model.MedicoesDocumentos;
import br.com.projeta_api.repository.CicloRepository;
import br.com.projeta_api.repository.DocumentosRepository;
import br.com.projeta_api.repository.MedicoesDocumentosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoesDocumentosService {

    private final MedicoesDocumentosRepository medicoesDocumentosRepository;

    private final DocumentosRepository documentosRepository;

    private final CicloRepository cicloRepository;

    public MedicoesDocumentosService(MedicoesDocumentosRepository medicoesDocumentosRepository, DocumentosRepository documentosRepository, CicloRepository cicloRepository) {
        this.medicoesDocumentosRepository = medicoesDocumentosRepository;
        this.documentosRepository = documentosRepository;
        this.cicloRepository = cicloRepository;
    }

    public List<MedicoesDocumentos> getAllMedicoes() {
        List<MedicoesDocumentos> lista = medicoesDocumentosRepository.findAll();
        if (lista.isEmpty()) {
            throw new RuntimeException("Nenhum boletim encontrado.");
        }
        return lista;
    }


    public MedicoesDocumentosDTO saveMedicao(MedicoesDocumentosDTO dto) {
        try {
            MedicoesDocumentos entity = new MedicoesDocumentos();

            Documentos doc = documentosRepository.findById(dto.getDocumentoId()).orElseThrow(() -> new RuntimeException("Nenhum documento encontrado."));

            Ciclo ciclo = cicloRepository.findById(dto.getCicloId()).orElseThrow(() -> new RuntimeException("Nenhum documento encontrado."));
            entity.setDocumento(doc);
            entity.setCiclo(ciclo);
            entity.setNumeroBoletim(dto.getNumeroBoletim());
            entity.setRevisaoBoletim(dto.getRevisaoBoletim());
            entity.setQuantidade(dto.getQuantidade());
            entity.setValorUnitario(dto.getValorUnitario());
            entity.setValorTotal(dto.getValorTotal());
            entity.setValorMedido(dto.getValorMedido());
            entity.setPercentualRevisao(dto.getPercentualRevisao());
            entity.setCreatedAt(dto.getCreatedAt());

            MedicoesDocumentos savedEntity = medicoesDocumentosRepository.save(entity);
            dto.setId(savedEntity.getId());

            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar boletim." + e.getMessage());
        }
    }


    public MedicoesDocumentosDTO updateMedicao(MedicoesDocumentosDTO dto) {
        try {
            MedicoesDocumentos entity = medicoesDocumentosRepository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("Boletim não encontrado com ID: " + dto.getId()));

            Documentos docUp = documentosRepository.findById(dto.getDocumentoId()).orElseThrow(() -> new RuntimeException("Nenhum documento encontrado."));

            Ciclo cicloUp = cicloRepository.findById(entity.getCiclo().getId()).orElseThrow(() -> new RuntimeException("Nenhum documento encontrado."));

            entity.setDocumento(docUp);
            entity.setCiclo(cicloUp);
            entity.setNumeroBoletim(dto.getNumeroBoletim());
            entity.setRevisaoBoletim(dto.getRevisaoBoletim());
            entity.setQuantidade(dto.getQuantidade());
            entity.setValorUnitario(dto.getValorUnitario());
            entity.setValorTotal(dto.getValorTotal());
            entity.setValorMedido(dto.getValorMedido());
            entity.setPercentualRevisao(dto.getPercentualRevisao());
            entity.setCreatedAt(dto.getCreatedAt());

            medicoesDocumentosRepository.save(entity);
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar boletim.", e);
        }
    }


    public MedicoesDocumentos getMedicaoById(Long id) {
        return medicoesDocumentosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Boletim não encontrado com ID: " + id));
    }


    public void deleteMedicao(Long id) {
        if (!medicoesDocumentosRepository.existsById(id)) {
            throw new RuntimeException("Boletim não encontrado com ID: " + id);
        }
        medicoesDocumentosRepository.deleteById(id);
    }


    public boolean existePorId(Long id) {
        return medicoesDocumentosRepository.existsById(id);
    }
}