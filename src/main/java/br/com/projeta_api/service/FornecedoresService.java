package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.FornecedoresDTO;
import br.com.projeta_api.model.Fornecedores;
import br.com.projeta_api.repository.FornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class FornecedoresService {
    @Autowired
    private FornecedoresRepository fornecedoresRepository;

    public FornecedoresDTO fornecedor(FornecedoresDTO fornecedoresDTO){
        Fornecedores entity = new Fornecedores();
        entity.setContrato_id(fornecedoresDTO.getContrato_id());
        entity.setNome(fornecedoresDTO.getNome());
        entity.setTipo(fornecedoresDTO.getTipo());
        fornecedoresRepository.save(entity);
        return fornecedoresDTO;
    }
    public Stream<FornecedoresDTO> listarFornecedores(){
        List<Fornecedores> entity = fornecedoresRepository.findAll();
        return entity.stream().map(fornecedores -> new FornecedoresDTO(
                fornecedores.getId(), fornecedores.getContrato_id(),
                fornecedores.getNome(), fornecedores.getTipo()
        ));
    }
    public FornecedoresDTO fornecedoresPorId(Long id){
        Fornecedores entity = fornecedoresRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        return new FornecedoresDTO(
                entity.getId(), entity.getContrato_id(),
                entity.getNome(), entity.getTipo()
        );
    }
    public void atualizarFornecedor(Long id, FornecedoresDTO fornecedoresDTO){
        Fornecedores entity = fornecedoresRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        entity.setContrato_id(fornecedoresDTO.getContrato_id());
        entity.setNome(fornecedoresDTO.getNome());
        entity.setTipo(fornecedoresDTO.getTipo());
        fornecedoresRepository.save(entity);
    }
    public void deletarFornecedor(Long id){
        fornecedoresRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        fornecedoresRepository.deleteById(id);
    }
}
