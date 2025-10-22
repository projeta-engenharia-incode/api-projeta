package br.com.projeta_api.service;

import br.com.projeta_api.model.EntregasCiclo;
import br.com.projeta_api.repository.EntregasCicloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntregasCicloService {

    private final EntregasCicloRepository entregasCicloRepository;

    public EntregasCiclo criarEntrega(EntregasCiclo entrega) {
        return entregasCicloRepository.save(entrega);
    }

    public List<EntregasCiclo> listarTodas(){
        return entregasCicloRepository.findAll();
    }

    public EntregasCiclo buscarPorId(Long id){
        return entregasCicloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrega do ciclo não encontrada com o ID: " + id));
    }

    public EntregasCiclo atualizarEntrega(Long id, EntregasCiclo entregaAtualizada) {
        EntregasCiclo entregaExistente = buscarPorId(id);
        entregaExistente.setDocumento(entregaAtualizada.getDocumento());
        entregaExistente.setCiclo(entregaAtualizada.getCiclo());
        entregaExistente.setDataEntrega(entregaAtualizada.getDataEntrega());
        entregaExistente.setPercentualCobrado(entregaAtualizada.getPercentualCobrado());
        entregaExistente.setValorCobrado(entregaAtualizada.getValorCobrado());
        entregaExistente.setStatusCobranca(entregaAtualizada.getStatusCobranca());

        return entregasCicloRepository.save(entregaExistente);
    }

    public void deletarEntrega(Long id){
        EntregasCiclo entrega = buscarPorId(id);
        entregasCicloRepository.deleteById(entrega.getId());
    }

    public boolean existeEntregaPorId(Long id){
        return entregasCicloRepository.existsById(id);
    }
}
