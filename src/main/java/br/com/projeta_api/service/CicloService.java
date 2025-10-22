package br.com.projeta_api.service;

import br.com.projeta_api.model.Ciclo;
import br.com.projeta_api.repository.CicloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CicloService {

    final CicloRepository cicloRepository;


    public Ciclo criar(Ciclo ciclo){
        return cicloRepository.save(ciclo);
    }

    public List<Ciclo> listar(){
        return cicloRepository.findAll();
    }

    public Ciclo buscarPorId(Long id){
        return cicloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ciclo não encontrado com o ID: " + id));
    }

    public Ciclo atualizar(Long id, Ciclo ciclo){
        Ciclo cicloExisente = buscarPorId(id);
        cicloExisente.setNome(ciclo.getNome());
        cicloExisente.setUpdatedAt(ciclo.getUpdatedAt());

        return cicloRepository.save(cicloExisente);
    }

    public void deletar(Long id){
        Ciclo ciclo = buscarPorId(id);
        cicloRepository.deleteById(ciclo.getId());
    }

    public boolean existePorId(Long id){
        return cicloRepository.existsById(id);
    }
}
