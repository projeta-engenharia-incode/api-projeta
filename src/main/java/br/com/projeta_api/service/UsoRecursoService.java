package br.com.projeta_api.service;


import br.com.projeta_api.DTO.request.UsoRecursosDTO;
import br.com.projeta_api.model.Documentos;
import br.com.projeta_api.model.Recurso;
import br.com.projeta_api.model.UsoRecursos;
import br.com.projeta_api.repository.DocumentosRepository;
import br.com.projeta_api.repository.RecursoRepository;
import br.com.projeta_api.repository.UsoRecursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class UsoRecursoService {

    private final UsoRecursosRepository usoRecursosRepository;

    private final RecursoRepository  recursoRepository;

    private final DocumentosRepository documentosRepository;

    public UsoRecursoService(UsoRecursosRepository usoRecursosRepository,  RecursoRepository recursoRepository,  DocumentosRepository documentosRepository) {
        this.usoRecursosRepository = usoRecursosRepository;
        this.recursoRepository = recursoRepository;
        this.documentosRepository = documentosRepository;
    }

    // Salvar uso de recurso
    public UsoRecursosDTO saveUsoRecurso(UsoRecursosDTO dto) {
        try {
            UsoRecursos entity = new UsoRecursos();
            Recurso recurso = recursoRepository.findById(dto.getRecursoId()).orElseThrow(() -> new RuntimeException("ERRO"));
            Documentos doc = documentosRepository.findById(dto.getDocumentoId()).orElseThrow(() -> new RuntimeException("ERRO"));
            entity.setRecurso(recurso);
            entity.setDocumentos(doc);
            entity.setQuantidadeUsada(dto.getQuantidadeUsada());
            entity.setDataUso(dto.getDataUso());

            UsoRecursos saved = usoRecursosRepository.save(entity);
            dto.setId(saved.getId());
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar uso de recurso.", e);
        }
    }

    // Listar todos os usos de recurso
    public List<UsoRecursosDTO> listarUsoRecursos() {
        List<UsoRecursos> entities = usoRecursosRepository.findAll();
        if (entities.isEmpty()) {
            throw new RuntimeException("Nenhum uso de recurso encontrado.");
        }

        return entities.stream()
                .map(u -> new UsoRecursosDTO(
                        u.getId(),
                        u.getRecurso().getId(),
                        u.getDocumentos().getId(),
                        u.getQuantidadeUsada(),
                        u.getDataUso()
                ))
                .toList();
    }

    // Buscar uso de recurso por ID
    public UsoRecursosDTO getUsoRecursoById(Long id) {
        UsoRecursos entity = usoRecursosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Uso de recurso não encontrado com ID: " + id));

        return new UsoRecursosDTO(
                entity.getId(),
                entity.getRecurso().getId(),
                entity.getDocumentos().getId(),
                entity.getQuantidadeUsada(),
                entity.getDataUso()
        );
    }

    // Atualizar uso de recurso
    public UsoRecursosDTO updateUsoRecurso(Long id, UsoRecursosDTO dto) {
        UsoRecursos entity = usoRecursosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Uso de recurso não encontrado com ID: " + id));

        Recurso recursoUp = recursoRepository.findById(dto.getRecursoId()).orElseThrow(() -> new RuntimeException("ERRO"));
        Documentos docUp = documentosRepository.findById(dto.getDocumentoId()).orElseThrow(() -> new RuntimeException("ERRO"));

        entity.setRecurso(recursoUp);
        entity.setDocumentos(docUp);
        entity.setQuantidadeUsada(dto.getQuantidadeUsada());
        entity.setDataUso(dto.getDataUso());

        UsoRecursos updated = usoRecursosRepository.save(entity);
        dto.setId(updated.getId());
        return dto;
    }

    // Deletar uso de recurso
    public void deleteUsoRecurso(Long id) {
        if (!usoRecursosRepository.existsById(id)) {
            throw new RuntimeException("Uso de recurso não encontrado com ID: " + id);
        }
        usoRecursosRepository.deleteById(id);
    }
}
