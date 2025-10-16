package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.TiposRejeicoesDTO;
import br.com.projeta_api.model.TiposRejeicoes;
import br.com.projeta_api.repository.TiposRejeicoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class TiposRejeicoesService {
    @Autowired
    private TiposRejeicoesRepository tiposRejeicoesRepository;

    public TiposRejeicoesDTO tipoRejeicao(TiposRejeicoesDTO dto){
        TiposRejeicoes entity = new TiposRejeicoes();
        entity.setCodigo(dto.getCodigo());
        entity.setDescricao(dto.getDescricao());
        tiposRejeicoesRepository.save(entity);
        return dto;
    }
    public Stream<TiposRejeicoesDTO> listarTiposRejeicoes(){
        List<TiposRejeicoes> entity = tiposRejeicoesRepository.findAll();
        return entity.stream().map(tiposRejeicoes -> new TiposRejeicoesDTO(
                tiposRejeicoes.getId(), tiposRejeicoes.getCodigo(), tiposRejeicoes.getDescricao()
        ));
    }
    public TiposRejeicoesDTO tiposRejeicoesPorId(Long id){
        TiposRejeicoes entity = tiposRejeicoesRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        return new TiposRejeicoesDTO(
                entity.getId(), entity.getCodigo(), entity.getDescricao());
    }
    public void atualizarTipoRejeicao(Long id, TiposRejeicoesDTO dto){
        TiposRejeicoes entity = tiposRejeicoesRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        entity.setCodigo(dto.getCodigo());
        entity.setDescricao(dto.getDescricao());
        tiposRejeicoesRepository.save(entity);
    }
    public void deletarTipoRejeicao(Long id){
        TiposRejeicoes entity = tiposRejeicoesRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        tiposRejeicoesRepository.deleteById(id);
    }
}
