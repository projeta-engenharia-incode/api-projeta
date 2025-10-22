package br.com.projeta_api.service;


import br.com.projeta_api.dto.CobrancasDTO;
import br.com.projeta_api.model.Ciclo;
import br.com.projeta_api.model.Cobrancas;
import br.com.projeta_api.repository.CicloRepository;
import br.com.projeta_api.repository.CobrancasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CobrancasService {

    private final CobrancasRepository cobrancasRepository;

    private final CicloRepository cicloRepository;

    public CobrancasService(CobrancasRepository cobrancasRepository, CicloRepository cicloRepository) {
        this.cobrancasRepository = cobrancasRepository;
        this.cicloRepository = cicloRepository;
    }

    public CobrancasDTO criarCobranca(CobrancasDTO dto) {

        try {
            Cobrancas entity = new Cobrancas();

            Ciclo ciclo = cicloRepository.findById(entity.getCiclo().getId()).orElseThrow(() -> new RuntimeException("ERRO"));

            entity.setCliente(dto.getCliente());
            entity.setDataEmissao(dto.getDataEmissao());
            entity.setValorTotal(dto.getValorTotal());
            entity.setStatusCobranca(dto.getStatusCobranca());
            entity.setCiclo(ciclo);

            Cobrancas saved = cobrancasRepository.save(entity);
            dto.setId(saved.getId());
            return dto;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar cobrança.", e);
        }
    }

    public List<CobrancasDTO> listarCobrancas() {
        List<Cobrancas> entities = cobrancasRepository.findAll();

        if (entities.isEmpty()) {
            throw new RuntimeException("Nenhuma cobrança encontrada.");
        }

        return entities.stream()
                .map(c -> new CobrancasDTO(
                        c.getId(),
                        c.getCiclo().getId(),
                        c.getCliente(),
                        c.getDataEmissao(),
                        c.getValorTotal(),
                        c.getStatusCobranca()

                ))
                .toList();
    }

    public CobrancasDTO buscarCobrancaPorId(Long id) {
        Cobrancas entity = cobrancasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cobrança não encontrada com o ID: " + id));

        return new CobrancasDTO(
                entity.getId(),
                entity.getCiclo().getId(),
                entity.getCliente(),
                entity.getDataEmissao(),
                entity.getValorTotal(),
                entity.getStatusCobranca()

        );
    }

    public CobrancasDTO atualizarCobranca(Long id, CobrancasDTO dto) {
        try {
            Cobrancas entity = cobrancasRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Cobrança não encontrada com o ID: " + id));

            Ciclo ciclo = cicloRepository.findById(entity.getCiclo().getId()).orElseThrow(() -> new RuntimeException("ERRO"));

            entity.setCliente(dto.getCliente());
            entity.setDataEmissao(dto.getDataEmissao());
            entity.setValorTotal(dto.getValorTotal());
            entity.setStatusCobranca(dto.getStatusCobranca());
            entity.setCiclo(ciclo);

            Cobrancas updated = cobrancasRepository.save(entity);
            dto.setId(updated.getId());
            return dto;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar cobrança.", e);
        }
    }

    public void deletarCobranca(Long id) {
        if (!cobrancasRepository.existsById(id)) {
            throw new RuntimeException("Cobrança não encontrada com o ID: " + id);
        }
        cobrancasRepository.deleteById(id);
    }

    public boolean existeCobrancaPorId(Long id) {
        return cobrancasRepository.existsById(id);
    }
}
