package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.AprovacoesCicloDTO;
import br.com.projeta_api.model.AprovacoesCiclo;
import br.com.projeta_api.repository.AprovacoesCicloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class AprovacoesCicloService {
    @Autowired
    private AprovacoesCicloRepository aprovacoesCicloRepository;

    public AprovacoesCicloDTO aprovacaoCiclo(AprovacoesCicloDTO dto){
        AprovacoesCiclo  ciclo = new AprovacoesCiclo();
        ciclo.setDocumentos(dto.getDocumento());
        ciclo.setCiclo(dto.getCiclo());
        ciclo.setData_aprovacao(dto.getData_aprovacao());
        ciclo.setAutorizado_por(dto.getAutorizado_por());
        ciclo.setStatus_aprovacao(dto.getStatus_aprovacao());
        ciclo.setObservacoes(dto.getObservacoes());
        aprovacoesCicloRepository.save(ciclo);
        return dto;
    }
    public Stream<AprovacoesCicloDTO> listarAprovacoesCiclos(){
        List<AprovacoesCiclo> entity = aprovacoesCicloRepository.findAll();
        return entity.stream().map(aprovacoesCiclos -> new AprovacoesCicloDTO(
            aprovacoesCiclos.getId(), aprovacoesCiclos.getDocumentos(), aprovacoesCiclos.getCiclo(), aprovacoesCiclos.getData_aprovacao(),
                aprovacoesCiclos.getAutorizado_por(), aprovacoesCiclos.getStatus_aprovacao(), aprovacoesCiclos.getObservacoes()
        ));
    }
    public AprovacoesCicloDTO aprovacoesCiclosPorId(Long id){
        AprovacoesCiclo ciclo = aprovacoesCicloRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        return new AprovacoesCicloDTO(
                ciclo.getId(), ciclo.getDocumentos(), ciclo.getCiclo(), ciclo.getData_aprovacao(),
                ciclo.getAutorizado_por(), ciclo.getStatus_aprovacao(), ciclo.getObservacoes()
        );
    }
    public void atualizarAprovacaoCiclo(Long id, AprovacoesCicloDTO cicloDTO){
        AprovacoesCiclo ciclo = aprovacoesCicloRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        ciclo.setDocumentos(cicloDTO.getDocumento());
        ciclo.setCiclo(cicloDTO.getCiclo());
        ciclo.setData_aprovacao(cicloDTO.getData_aprovacao());
        ciclo.setAutorizado_por(cicloDTO.getAutorizado_por());
        ciclo.setStatus_aprovacao(cicloDTO.getStatus_aprovacao());
        ciclo.setObservacoes(cicloDTO.getObservacoes());
        aprovacoesCicloRepository.save(ciclo);
    }
    public void deletarAprovacaoCiclo(Long id){
        aprovacoesCicloRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        aprovacoesCicloRepository.deleteById(id);
    }
}
