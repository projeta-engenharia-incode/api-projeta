package br.com.projeta_api.service;

import br.com.projeta_api.dto.RecursoDTO;
import br.com.projeta_api.model.Recurso;
import br.com.projeta_api.repository.RecursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoService {

    private final RecursoRepository recursoRepository;

    public RecursoService(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }


    public List<Recurso> getAllRecursos() {
        List<Recurso> lista = recursoRepository.findAll();
        if (lista.isEmpty()) {
            throw new RuntimeException("Nenhum recurso encontrado.");
        }
        return lista;
    }


    public RecursoDTO saveRecurso(RecursoDTO dto) {
        try {
            Recurso entity = new Recurso();
            entity.setNome(dto.getNome());
            entity.setTipo(dto.getTipo());
            entity.setQuantidadeTotal(dto.getQuantidadeTotal());

            Recurso savedEntity = recursoRepository.save(entity);
            dto.setId(savedEntity.getId());
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar recurso.", e);
        }
    }


    public RecursoDTO updateRecurso(RecursoDTO dto) {
        try {
            Recurso entity = recursoRepository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("Recurso não encontrado com o ID: " + dto.getId()));

            entity.setNome(dto.getNome());
            entity.setTipo(dto.getTipo());
            entity.setQuantidadeTotal(dto.getQuantidadeTotal());

            recursoRepository.save(entity);
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar recurso.", e);
        }
    }


    public Recurso getRecursoById(Long id) {
        return recursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recurso não encontrado com o ID: " + id));
    }


    public void deleteRecurso(Long id) {
        if (!recursoRepository.existsById(id)) {
            throw new RuntimeException("Recurso não encontrado com o ID: " + id);
        }
        recursoRepository.deleteById(id);
    }

    public boolean existeRecurso(Long id) {
        return recursoRepository.existsById(id);
    }
}
