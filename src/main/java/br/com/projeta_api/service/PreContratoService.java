package br.com.projeta_api.service;

import br.com.projeta_api.model.PreContrato;
import br.com.projeta_api.repository.PreContratoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PreContratoService {

    private final PreContratoRepository preContratoRepository;

    public PreContrato criarPreContrato(PreContrato preContrato){
        return preContratoRepository.save(preContrato);
    }

    public List<PreContrato> listarTodos(){
        return preContratoRepository.findAll();

    }

    public PreContrato buscarPorId(Long id){
        return preContratoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PreContrato não encontrado com o ID: " + id));
    }

    public PreContrato atualizarPreContrato(Long id, PreContrato preContratoAtualizado) {
        PreContrato preContratoExistente = buscarPorId(id);

        preContratoExistente.setChamadoId(preContratoAtualizado.getChamadoId());
        preContratoExistente.setTitulo(preContratoAtualizado.getTitulo());
        preContratoExistente.setDescricao(preContratoAtualizado.getDescricao());
        preContratoExistente.setStatus(preContratoAtualizado.getStatus());
        preContratoExistente.setValorEstimado(preContratoAtualizado.getValorEstimado());
        preContratoExistente.setDataProposta(preContratoAtualizado.getDataProposta());
        preContratoExistente.setDataValidade(preContratoAtualizado.getDataValidade());
        preContratoExistente.setCreatedAt(preContratoAtualizado.getCreatedAt());

        return preContratoRepository.save(preContratoExistente);
    }

    public void deletarPreContrato(Long id){
        PreContrato preContrato = buscarPorId(id);
        preContratoRepository.delete(preContrato);
    }

    public boolean existePreContrato(Long id){
        return preContratoRepository.existsById(id);
    }
}
