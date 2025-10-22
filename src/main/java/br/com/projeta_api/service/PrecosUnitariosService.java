package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.PrecosUnitariosDTO;
import br.com.projeta_api.model.PrecosUnitarios;
import br.com.projeta_api.repository.PrecosUnitariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class PrecosUnitariosService {
    @Autowired
    private PrecosUnitariosRepository precosUnitariosRepository;

    public PrecosUnitariosDTO precoUnitario(PrecosUnitariosDTO dto){
        PrecosUnitarios entity = new PrecosUnitarios();
        entity.setContratoId(dto.getContratoId());
        entity.setContrato(dto.getContrato());
        entity.setDescricao(dto.getDescricao());
        entity.setFormato(dto.getFormato());
        entity.setQuantidade(dto.getQuantidade());
        entity.setPrecoUnitario(dto.getPrecoUnitario());
        precosUnitariosRepository.save(entity);
        return dto;
    }
    public Stream<PrecosUnitariosDTO> listarPrecosUnitarios(){
        List<PrecosUnitarios> entity  = precosUnitariosRepository.findAll();
        return entity.stream().map(
                precosUnitarios -> new PrecosUnitariosDTO(
                        precosUnitarios.getId(), precosUnitarios.getContratoId(), precosUnitarios.getContrato(), precosUnitarios.getDescricao(),
                        precosUnitarios.getFormato(), precosUnitarios.getQuantidade(), precosUnitarios.getPrecoUnitario()
                ));
    }
    public PrecosUnitariosDTO precosUnitariosPorId(Long id){
        PrecosUnitarios entity = precosUnitariosRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        return new PrecosUnitariosDTO(
                entity.getId(), entity.getContratoId(), entity.getContrato(), entity.getDescricao(),
                entity.getFormato(), entity.getQuantidade(), entity.getPrecoUnitario()
        );
    }
    public void atualizarPrecoUnitario(Long id , PrecosUnitariosDTO dto){
        PrecosUnitarios entity = precosUnitariosRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        entity.setContratoId(dto.getContratoId());
        entity.setContrato(dto.getContrato());
        entity.setDescricao(dto.getDescricao());
        entity.setFormato(dto.getFormato());
        entity.setQuantidade(dto.getQuantidade());
        entity.setPrecoUnitario(dto.getPrecoUnitario());
        precosUnitariosRepository.save(entity);
    }
    public void deletarPrecoUnitario(Long id){
        precosUnitariosRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        precosUnitariosRepository.deleteById(id);
    }
}
