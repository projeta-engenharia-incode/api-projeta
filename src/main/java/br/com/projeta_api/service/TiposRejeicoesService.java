package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.TiposRejeicoesDTO;
import br.com.projeta_api.model.TiposRejeicoes;
import br.com.projeta_api.repository.TiposRejeicoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiposRejeicoesService {

    private final TiposRejeicoesRepository tiposRejeicoesRepository;

    public TiposRejeicoesService(TiposRejeicoesRepository tiposRejeicoesRepository) {
        this.tiposRejeicoesRepository = tiposRejeicoesRepository;
    }

    public TiposRejeicoesDTO saveTipoRejeicao(TiposRejeicoesDTO dto) {
        try {
            TiposRejeicoes entity = new TiposRejeicoes();
            entity.setCodigo(dto.getCodigo());
            entity.setDescricao(dto.getDescricao());

            TiposRejeicoes saved = tiposRejeicoesRepository.save(entity);
            dto.setId(saved.getId());
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar tipo de rejeição.", e);
        }
    }

    public List<TiposRejeicoesDTO> listarTiposRejeicoes() {
        List<TiposRejeicoes> entities = tiposRejeicoesRepository.findAll();
        if (entities.isEmpty()) {
            throw new RuntimeException("Nenhum tipo de rejeição encontrado.");
        }

        return entities.stream()
                .map(tipo -> new TiposRejeicoesDTO(
                        tipo.getId(),
                        tipo.getCodigo(),
                        tipo.getDescricao()
                ))
                .toList();
    }

    public TiposRejeicoesDTO getTipoRejeicaoById(Long id) {
        TiposRejeicoes entity = tiposRejeicoesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de rejeição não encontrado com ID: " + id));

        return new TiposRejeicoesDTO(
                entity.getId(),
                entity.getCodigo(),
                entity.getDescricao()
        );
    }

    public TiposRejeicoesDTO updateTipoRejeicao(Long id, TiposRejeicoesDTO dto) {
        TiposRejeicoes entity = tiposRejeicoesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de rejeição não encontrado com ID: " + id));

        entity.setCodigo(dto.getCodigo());
        entity.setDescricao(dto.getDescricao());

        TiposRejeicoes updated = tiposRejeicoesRepository.save(entity);
        dto.setId(updated.getId());
        return dto;
    }

    public void deleteTipoRejeicao(Long id) {
        if (!tiposRejeicoesRepository.existsById(id)) {
            throw new RuntimeException("Tipo de rejeição não encontrado com ID: " + id);
        }
        tiposRejeicoesRepository.deleteById(id);
    }
}
