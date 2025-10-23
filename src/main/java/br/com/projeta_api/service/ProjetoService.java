package br.com.projeta_api.service;

import br.com.projeta_api.dto.ProjetoDTO;
import br.com.projeta_api.model.Contrato;
import br.com.projeta_api.model.Projeto;
import br.com.projeta_api.repository.ContratoRepository;
import br.com.projeta_api.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    private final ContratoRepository contratoRepository;

    public ProjetoService(ProjetoRepository projetoRepository, ContratoRepository contratoRepository) {
        this.projetoRepository = projetoRepository;
        this.contratoRepository = contratoRepository;
    }


    public List<Projeto> getAllProjetos() {
        List<Projeto> lista = projetoRepository.findAll();
        if (lista.isEmpty()) {
            throw new RuntimeException("Nenhum projeto encontrado.");
        }
        return lista;
    }


    public ProjetoDTO saveProjeto(ProjetoDTO dto) {
        try {
            Projeto entity = new Projeto();

            Contrato contrato = contratoRepository.findById(dto.getContratoId()).orElseThrow(() -> new RuntimeException("ERRO"));
            entity.setTitulo(dto.getTitulo());
            entity.setDisciplina(dto.getDisciplina());
            entity.setStatusGeral(dto.getStatusGeral());
            entity.setContrato(contrato);
            entity.setUpdatedAt(dto.getUpdatedAt());

            Projeto savedEntity = projetoRepository.save(entity);
            dto.setId(savedEntity.getId());
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar projeto." + e.getMessage());
        }
    }


    public ProjetoDTO updateProjeto(ProjetoDTO dto) {
        try {
            Projeto entity = projetoRepository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("Projeto não encontrado com o ID: " + dto.getId()));

            Contrato contratoUp = contratoRepository.findById(entity.getContrato().getId()).orElseThrow(() -> new RuntimeException("ERRO"));
            entity.setTitulo(dto.getTitulo());
            entity.setDisciplina(dto.getDisciplina());
            entity.setStatusGeral(dto.getStatusGeral());
            entity.setContrato(contratoUp);
            entity.setUpdatedAt(dto.getUpdatedAt());

            projetoRepository.save(entity);
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar projeto.", e);
        }
    }


    public Projeto getProjetoById(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado com o ID: " + id));
    }


    public void deleteProjeto(Long id) {
        if (!projetoRepository.existsById(id)) {
            throw new RuntimeException("Projeto não encontrado com o ID: " + id);
        }
        projetoRepository.deleteById(id);
    }


    public boolean existsProjetoById(Long id) {
        return projetoRepository.existsById(id);
    }
}