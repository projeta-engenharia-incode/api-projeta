package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.RejeicoesRevisaoDTO;
import br.com.projeta_api.model.RejeicoesRevisao;
import br.com.projeta_api.repository.RejeicoesRevisaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class RejeicoesRevisaoService {
    @Autowired
    private RejeicoesRevisaoRepository rejeicoesRevisaoRepository;

    public RejeicoesRevisaoDTO rejeicaoRevisao(RejeicoesRevisaoDTO rejeicoesRevisaoDTO){
        RejeicoesRevisao entity = new RejeicoesRevisao();
        entity.setTiposRejeicoes(rejeicoesRevisaoDTO.getTiposRejeicoes());
        entity.setRevisoesDoc(rejeicoesRevisaoDTO.getRevisoesDoc());
        rejeicoesRevisaoRepository.save(entity);
        return rejeicoesRevisaoDTO;
    }
    public Stream<RejeicoesRevisaoDTO> listarRejeicoesRevisao(){
        List<RejeicoesRevisao> entity = rejeicoesRevisaoRepository.findAll();
        return entity.stream().map(rejeicoesRevisao -> new RejeicoesRevisaoDTO(
                rejeicoesRevisao.getId(), rejeicoesRevisao.getTiposRejeicoes(), rejeicoesRevisao.getRevisoesDoc()
        ));
    }
    public RejeicoesRevisaoDTO rejeicoesRevisaoPorId(Long id){
        RejeicoesRevisao entity = rejeicoesRevisaoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        return new RejeicoesRevisaoDTO(
                entity.getId(), entity.getTiposRejeicoes(), entity.getRevisoesDoc()
        );
    }
    public void atualizarRejeicaoRevisao(Long id, RejeicoesRevisaoDTO rejeicoesRevisaoDTO){
        RejeicoesRevisao entity = rejeicoesRevisaoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        entity.setTiposRejeicoes(rejeicoesRevisaoDTO.getTiposRejeicoes());
        entity.setRevisoesDoc(rejeicoesRevisaoDTO.getRevisoesDoc());
        rejeicoesRevisaoRepository.save(entity);
    }
    public void deletarRejeicaoRevisao(Long id){
        rejeicoesRevisaoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        rejeicoesRevisaoRepository.deleteById(id);
    }
}
