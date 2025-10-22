package br.com.projeta_api.service;

import br.com.projeta_api.dto.CicloDTO;
import br.com.projeta_api.model.Ciclo;
import br.com.projeta_api.repository.CicloRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CicloService {

    private final CicloRepository cicloRepository;

    public CicloService(CicloRepository cicloRepository) {
        this.cicloRepository = cicloRepository;
    }

    public CicloDTO criar(CicloDTO dto) {
        try {
            Ciclo entity = new Ciclo();
            entity.setNome(dto.getNome());
            entity.setCreatedAt(dto.getCreatedAt());
            entity.setUpdatedAt(dto.getUpdatedAt() != null ? dto.getUpdatedAt() : LocalDateTime.now());

            Ciclo saved = cicloRepository.save(entity);
            dto.setId(saved.getId());
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar ciclo.", e);
        }
    }

    public List<CicloDTO> listar() {
        List<Ciclo> entities = cicloRepository.findAll();
        if (entities.isEmpty()) {
            throw new RuntimeException("Nenhum ciclo encontrado.");
        }
        return entities.stream()
                .map(ciclo -> new CicloDTO(
                        ciclo.getId(),
                        ciclo.getNome(),
                        ciclo.getCreatedAt(),
                        ciclo.getUpdatedAt()
                ))
                .toList();
    }

    public CicloDTO buscarPorId(Long id) {
        Ciclo entity = cicloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ciclo não encontrado com ID: " + id));

        return new CicloDTO(
                entity.getId(),
                entity.getNome(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public CicloDTO atualizar(Long id, CicloDTO dto) {
        Ciclo entity = cicloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ciclo não encontrado com ID: " + id));

        entity.setNome(dto.getNome());
        entity.setUpdatedAt(dto.getUpdatedAt() != null ? dto.getUpdatedAt() : LocalDateTime.now());

        Ciclo updated = cicloRepository.save(entity);
        dto.setId(updated.getId());
        return dto;
    }

    public void deletar(Long id) {
        if (!cicloRepository.existsById(id)) {
            throw new RuntimeException("Ciclo não encontrado com ID: " + id);
        }
        cicloRepository.deleteById(id);
    }

    public boolean existePorId(Long id) {
        return cicloRepository.existsById(id);
    }
}
