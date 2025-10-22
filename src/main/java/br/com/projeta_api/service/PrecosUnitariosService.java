package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.PrecosUnitariosDTO;
import br.com.projeta_api.model.Contrato;
import br.com.projeta_api.model.PrecosUnitarios;
import br.com.projeta_api.repository.ContratoRepository;
import br.com.projeta_api.repository.PrecosUnitariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrecosUnitariosService {
    private final PrecosUnitariosRepository precosUnitariosRepository;

    private final ContratoRepository contratoRepository;

    public PrecosUnitariosService(PrecosUnitariosRepository precosUnitariosRepository, ContratoRepository contratoRepository) {
        this.precosUnitariosRepository = precosUnitariosRepository;
        this.contratoRepository = contratoRepository;
    }

    public PrecosUnitariosDTO savePrecoUnitario(PrecosUnitariosDTO dto) {
        try {
            PrecosUnitarios entity = new PrecosUnitarios();
            Contrato contrato = contratoRepository.findById(dto.getContratoId()).orElseThrow(() -> new RuntimeException("ERRO"));
            entity.setContrato(contrato);
            entity.setDescricao(dto.getDescricao());
            entity.setFormato(dto.getFormato());
            entity.setQuantidade(dto.getQuantidade());
            entity.setPrecoUnitario(dto.getPrecoUnitario());

            PrecosUnitarios saved = precosUnitariosRepository.save(entity);
            dto.setId(saved.getId());
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar preço unitário.", e);
        }
    }

    public List<PrecosUnitariosDTO> listarPrecosUnitarios() {
        List<PrecosUnitarios> entities = precosUnitariosRepository.findAll();
        if (entities.isEmpty()) {
            throw new RuntimeException("Nenhum preço unitário encontrado.");
        }

        return entities.stream()
                .map(p -> new PrecosUnitariosDTO(
                        p.getId(),
                        p.getContrato().getId(),
                        p.getDescricao(),
                        p.getFormato(),
                        p.getQuantidade(),
                        p.getPrecoUnitario()
                ))
                .toList();
    }

    public PrecosUnitariosDTO getPrecoUnitarioById(Long id) {
        PrecosUnitarios entity = precosUnitariosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Preço unitário não encontrado com ID: " + id));

        return new PrecosUnitariosDTO(
                entity.getId(),
                entity.getContrato().getId(),
                entity.getDescricao(),
                entity.getFormato(),
                entity.getQuantidade(),
                entity.getPrecoUnitario()
        );
    }

    public PrecosUnitariosDTO updatePrecoUnitario(Long id, PrecosUnitariosDTO dto) {
        PrecosUnitarios entity = precosUnitariosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Preço unitário não encontrado com ID: " + id));

        Contrato contratoUp = contratoRepository.findById(dto.getContratoId()).orElseThrow(() -> new RuntimeException("ERRO"));

        entity.setContrato(contratoUp);
        entity.setDescricao(dto.getDescricao());
        entity.setFormato(dto.getFormato());
        entity.setQuantidade(dto.getQuantidade());
        entity.setPrecoUnitario(dto.getPrecoUnitario());

        PrecosUnitarios updated = precosUnitariosRepository.save(entity);
        dto.setId(updated.getId());
        return dto;
    }

    public void deletePrecoUnitario(Long id) {
        if (!precosUnitariosRepository.existsById(id)) {
            throw new RuntimeException("Preço unitário não encontrado com ID: " + id);
        }
        precosUnitariosRepository.deleteById(id);
    }
}
