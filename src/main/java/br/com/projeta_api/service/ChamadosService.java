package br.com.projeta_api.service;

import br.com.projeta_api.dto.ChamadosDTO;
import br.com.projeta_api.model.Chamados;
import br.com.projeta_api.model.Contrato;
import br.com.projeta_api.repository.ChamadosRepository;
import br.com.projeta_api.repository.ContratoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChamadosService {

    private final ChamadosRepository chamadosRepository;

    private final ContratoRepository contratoRepository;

    public ChamadosService(ChamadosRepository chamadosRepository,  ContratoRepository contratoRepository) {
        this.chamadosRepository = chamadosRepository;
        this.contratoRepository = contratoRepository;
    }

    public ChamadosDTO criarChamado(ChamadosDTO dto) {
        try {
            Chamados entity = new Chamados();
            entity.setCoordenador(dto.getCoordenador());
            entity.setAtendido(dto.getAtendido());
            entity.setNomeProjeto(dto.getNomeProjeto());
            entity.setCodigoCliente(dto.getCodigoCliente());

            Contrato contrato = contratoRepository.findById(dto.getContratoId()).orElseThrow(() -> new RuntimeException("ERRO"));
            entity.setContrato(contrato);

            entity.setDataAbertura(dto.getDataAbertura());
            entity.setDataAgendamento(dto.getDataAgendamento());
            entity.setDataVisita(dto.getDataVisita());
            entity.setDataEstimativa(dto.getDataEstimativa());
            entity.setCreatedAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : LocalDateTime.now());

            Chamados saved = chamadosRepository.save(entity);
            dto.setId(saved.getId());
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar chamado.", e);
        }
    }

    public List<ChamadosDTO> listarTodos() {
        List<Chamados> entities = chamadosRepository.findAll();
        if (entities.isEmpty()) {
            throw new RuntimeException("Nenhum chamado encontrado.");
        }
        return entities.stream()
                .map(chamado -> new ChamadosDTO(
                        chamado.getId(),
                        chamado.getCoordenador(),
                        chamado.getAtendido(),
                        chamado.getNomeProjeto(),
                        chamado.getCodigoCliente(),
                        chamado.getContrato().getId(),
                        chamado.getDataAbertura(),
                        chamado.getDataAgendamento(),
                        chamado.getDataVisita(),
                        chamado.getDataEstimativa(),
                        chamado.getCreatedAt()
                ))
                .toList();
    }

    public ChamadosDTO buscarPorId(Long id) {
        Chamados entity = chamadosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado com ID: " + id));

        return new ChamadosDTO(
                entity.getId(),
                entity.getCoordenador(),
                entity.getAtendido(),
                entity.getNomeProjeto(),
                entity.getCodigoCliente(),
                entity.getContrato().getId(),
                entity.getDataAbertura(),
                entity.getDataAgendamento(),
                entity.getDataVisita(),
                entity.getDataEstimativa(),
                entity.getCreatedAt()
        );
    }

    public ChamadosDTO atualizarChamado(Long id, ChamadosDTO dto) {
        Chamados entity = chamadosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado com ID: " + id));

        Contrato contratoUp = contratoRepository.findById(dto.getContratoId()).orElseThrow(() -> new RuntimeException("ERRO"));

        entity.setCoordenador(dto.getCoordenador());
        entity.setAtendido(dto.getAtendido());
        entity.setNomeProjeto(dto.getNomeProjeto());
        entity.setCodigoCliente(dto.getCodigoCliente());
        entity.setContrato(contratoUp);
        entity.setDataAbertura(dto.getDataAbertura());
        entity.setDataAgendamento(dto.getDataAgendamento());
        entity.setDataVisita(dto.getDataVisita());
        entity.setDataEstimativa(dto.getDataEstimativa());
        entity.setCreatedAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : entity.getCreatedAt());

        Chamados updated = chamadosRepository.save(entity);
        dto.setId(updated.getId());
        return dto;
    }

    public void deletarChamado(Long id) {
        if (!chamadosRepository.existsById(id)) {
            throw new RuntimeException("Chamado não encontrado com ID: " + id);
        }
        chamadosRepository.deleteById(id);
    }

    public boolean existeChamado(Long id) {
        return chamadosRepository.existsById(id);
    }
}
