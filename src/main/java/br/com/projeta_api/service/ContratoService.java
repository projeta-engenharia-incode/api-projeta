package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.ContratoDTO;
import br.com.projeta_api.model.Contrato;
import br.com.projeta_api.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class ContratoService {
    @Autowired
    private ContratoRepository contratoRepository;

    public ContratoDTO contrato(ContratoDTO dto){
        Contrato entity = new Contrato();
        entity.setCodigo(dto.getCodigo());
        entity.setContrato(dto.getContrato());
        entity.setSubcontrato(dto.getSubcontrato());
        entity.setEmpresa(dto.getEmpresa());
        entity.setGestor(dto.getGestor());
        entity.setDataInicio(dto.getDataInicio());
        entity.setDataFim(dto.getDataFim());
        entity.setValorTotal(dto.getValorTotal());
        entity.setRevisao(dto.getRevisao());
        entity.setPreContrato(dto.getPreContrato());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        contratoRepository.save(entity);
        return dto;
    }
    public Stream<ContratoDTO> contratos(){
        List<Contrato> entity = contratoRepository.findAll();
        return entity.stream().map(
                contratos -> new ContratoDTO(
                        contratos.getId(), contratos.getCodigo(), contratos.getContrato(), contratos.getSubcontrato(), contratos.getEmpresa(),
                        contratos.getGestor(), contratos.getDataInicio(), contratos.getDataFim(), contratos.getValorTotal(), contratos.getRevisao(),
                        contratos.getPreContrato(), contratos.getCreatedAt(), contratos.getUpdatedAt()
                ));
    }
    public ContratoDTO contratoPorId(Long id){
        Contrato entity = contratoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        return new ContratoDTO(
                entity.getId(), entity.getCodigo(), entity.getContrato(), entity.getSubcontrato(), entity.getEmpresa(),
                entity.getGestor(), entity.getDataInicio(), entity.getDataFim(), entity.getValorTotal(), entity.getRevisao(),
                entity.getPreContrato(), entity.getCreatedAt(), entity.getUpdatedAt()
        );
    }
    public void atualizarContrato(Long id, ContratoDTO dto){
        Contrato entity = contratoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        entity.setCodigo(dto.getCodigo());
        entity.setContrato(dto.getContrato());
        entity.setSubcontrato(dto.getSubcontrato());
        entity.setEmpresa(dto.getEmpresa());
        entity.setGestor(dto.getGestor());
        entity.setDataInicio(dto.getDataInicio());
        entity.setDataFim(dto.getDataFim());
        entity.setValorTotal(dto.getValorTotal());
        entity.setRevisao(dto.getRevisao());
        entity.setPreContrato(dto.getPreContrato());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        contratoRepository.save(entity);
    }
    public void deletarContrato(Long id){
        contratoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        contratoRepository.deleteById(id);
    }
}
