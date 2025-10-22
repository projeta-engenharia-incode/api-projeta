package br.com.projeta_api.service;

import br.com.projeta_api.dto.PreContratoDTO;
import br.com.projeta_api.model.PreContrato;
import br.com.projeta_api.repository.PreContratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreContratoService {

    private final PreContratoRepository preContratoRepository;

    public PreContratoService(PreContratoRepository preContratoRepository) {
        this.preContratoRepository = preContratoRepository;
    }


    public List<PreContrato> getAllPreContratos() {
        List<PreContrato> lista = preContratoRepository.findAll();
        if (lista.isEmpty()) {
            throw new RuntimeException("Nenhum pré-contrato encontrado.");
        }
        return lista;
    }


    public PreContratoDTO savePreContrato(PreContratoDTO dto) {
        try {
            PreContrato entity = new PreContrato();
            entity.setChamadoId(dto.getChamadoId());
            entity.setTitulo(dto.getTitulo());
            entity.setDescricao(dto.getDescricao());
            entity.setStatus(dto.getStatus());
            entity.setValorEstimado(dto.getValorEstimado());
            entity.setDataProposta(dto.getDataProposta());
            entity.setDataValidade(dto.getDataValidade());
            entity.setCreatedAt(dto.getCreatedAt());

            PreContrato savedEntity = preContratoRepository.save(entity);
            dto.setId(savedEntity.getId());
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar pré-contrato.", e);
        }
    }


    public PreContratoDTO updatePreContrato(PreContratoDTO dto) {
        try {
            PreContrato entity = preContratoRepository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("Pré-contrato não encontrado com o ID: " + dto.getId()));

            entity.setChamadoId(dto.getChamadoId());
            entity.setTitulo(dto.getTitulo());
            entity.setDescricao(dto.getDescricao());
            entity.setStatus(dto.getStatus());
            entity.setValorEstimado(dto.getValorEstimado());
            entity.setDataProposta(dto.getDataProposta());
            entity.setDataValidade(dto.getDataValidade());
            entity.setCreatedAt(dto.getCreatedAt());

            preContratoRepository.save(entity);
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar pré-contrato.", e);
        }
    }


    public PreContrato getPreContratoById(Long id) {
        return preContratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pré-contrato não encontrado com o ID: " + id));
    }


    public void deletePreContrato(Long id) {
        if (!preContratoRepository.existsById(id)) {
            throw new RuntimeException("Pré-contrato não encontrado com o ID: " + id);
        }
        preContratoRepository.deleteById(id);
    }

    public boolean existePreContrato(Long id) {
        return preContratoRepository.existsById(id);
    }
}
