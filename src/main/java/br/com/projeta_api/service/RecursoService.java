package br.com.projeta_api.service;

import br.com.projeta_api.model.Recurso;
import br.com.projeta_api.repository.RecursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecursoService {

    private final RecursoRepository recursoRepository;

    public Recurso criarRecurso(Recurso recurso){
        return recursoRepository.save(recurso);
    }

    public List<Recurso> listarRecurso(){
        return recursoRepository.findAll();
    }

    public Recurso buscarRecursoPorId(Long id){
        return recursoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado com o ID: " + id));
    }

    public Recurso atualizarRecurso(Long id, Recurso recursoAtualizado) {
        Recurso recursoExistente = buscarRecursoPorId(id);

        recursoExistente.setNome(recursoAtualizado.getNome());
        recursoExistente.setTipo(recursoAtualizado.getTipo());
        recursoExistente.setQuantidadeTotal(recursoAtualizado.getQuantidadeTotal());

        return recursoRepository.save(recursoExistente);
    }

    public void deletarRecurso(Long id){
        Recurso recurso = buscarRecursoPorId(id);
        recursoRepository.delete(recurso);
    }

    public boolean existeRecurso(Long id){
        return recursoRepository.existsById(id);
    }
}
