package br.com.projeta_api.service;


import br.com.projeta_api.model.Cobrancas;
import br.com.projeta_api.repository.CobrancasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CobrancasService {

    private final CobrancasRepository cobrancasRepository;

    public Cobrancas criarCobranca(Cobrancas cobrancas) {
        return cobrancasRepository.save(cobrancas);
    }

    public List<Cobrancas> listarCobrancas(){
        return cobrancasRepository.findAll();
    }

    public Cobrancas buscarCobrancaPorId(Long id){
        return cobrancasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cobrança não encontrada com o ID: " + id));
    }

    public Cobrancas atualizarCobranca(Long id, Cobrancas cobrancas){
        Cobrancas cobrancasExistente = buscarCobrancaPorId(id);
        cobrancasExistente.setCliente(cobrancas.getCliente());
        cobrancasExistente.setDataEmissao(cobrancas.getDataEmissao());
        cobrancasExistente.setValorTotal(cobrancas.getValorTotal());
        cobrancasExistente.setStatusCobranca(cobrancas.getStatusCobranca());
        cobrancasExistente.setCiclo(cobrancas.getCiclo());

        return cobrancasRepository.save(cobrancasExistente);
    }

    public void deletarCobranca(Long id){
        Cobrancas cobrancas = buscarCobrancaPorId(id);
        cobrancasRepository.deleteById(cobrancas.getId());
    }

    public boolean existeCobrancaPorId(Long id){
        return cobrancasRepository.existsById(id);
    }
}
