package br.com.projeta_api.service;


import br.com.projeta_api.DTO.request.UsoRecursosDTO;
import br.com.projeta_api.model.UsoRecursos;
import br.com.projeta_api.repository.UsoRecursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class UsoRecursoService {
    @Autowired
    private UsoRecursosRepository usoRecursosRepository;

    public UsoRecursosDTO usoRecursos(UsoRecursosDTO usoRecursoDTO){
        UsoRecursos entity = new UsoRecursos();
        entity.setRecursoId(usoRecursoDTO.getRecursoId());
        entity.setDocumentoId(usoRecursoDTO.getDocumentoId());
        entity.setQuantidadeUsada(usoRecursoDTO.getQuantidadeUsada());
        entity.setDataUso(usoRecursoDTO.getDataUso());
        usoRecursosRepository.save(entity);
        return usoRecursoDTO;
    }
    public Stream<UsoRecursosDTO> listarUsoRecursos(){
        List<UsoRecursos> entity = usoRecursosRepository.findAll();
        return entity.stream().map(
                usoRecursos -> new UsoRecursosDTO(
                 usoRecursos.getId(), usoRecursos.getRecursoId(), usoRecursos.getDocumentoId(),
                        usoRecursos.getQuantidadeUsada(), usoRecursos.getDataUso()
                ));
    }
    public UsoRecursosDTO usoRecursosPorId(Long id){
        UsoRecursos entity = usoRecursosRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        return new UsoRecursosDTO(entity.getId(), entity.getRecursoId(), entity.getDocumentoId(),
                entity.getQuantidadeUsada(), entity.getDataUso());
    }
    public void atualizarUsoRecurso(Long id , UsoRecursosDTO dto){
        UsoRecursos entity = usoRecursosRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        entity.setRecursoId(dto.getRecursoId());
        entity.setDocumentoId(dto.getDocumentoId());
        entity.setQuantidadeUsada(dto.getQuantidadeUsada());
        entity.setDataUso(dto.getDataUso());
        usoRecursosRepository.save(entity);
    }
    public void deletarUsoRecurso(Long id){
        usoRecursosRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        usoRecursosRepository.deleteById(id);
    }
}
