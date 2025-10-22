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

    private final AprovacoesCicloRepository aprovacoesCicloRepository;

    public AprovacoesCicloService( AprovacoesCicloRepository  aprovacoesCicloRepository) {
        this.aprovacoesCicloRepository = aprovacoesCicloRepository;
    }

    public AprovacoesCicloDTO aprovacaoCiclo(AprovacoesCicloDTO aprovacoesCicloDTO){
        AprovacoesCiclo  ciclo = new AprovacoesCiclo();
        ciclo.setDocumento_id(aprovacoesCicloDTO.getDocumento_id());
        ciclo.setCiclo_id(aprovacoesCicloDTO.getCiclo_id());
        ciclo.setData_aprovacao(aprovacoesCicloDTO.getData_aprovacao());
        ciclo.setAutorizado_por(aprovacoesCicloDTO.getAutorizado_por());
        ciclo.setStatus_aprovacao(aprovacoesCicloDTO.getStatus_aprovacao());
        ciclo.setObservacoes(aprovacoesCicloDTO.getObservacoes());
        aprovacoesCicloRepository.save(ciclo);
        return aprovacoesCicloDTO;
    }
    public Stream<AprovacoesCicloDTO> listarAprovacoesCiclos(){
        List<AprovacoesCiclo> entity = aprovacoesCicloRepository.findAll();
        return entity.stream().map(aprovacoesCiclos -> new AprovacoesCicloDTO(
            aprovacoesCiclos.getId(), aprovacoesCiclos.getDocumento_id(), aprovacoesCiclos.getCiclo_id(), aprovacoesCiclos.getData_aprovacao(),
                aprovacoesCiclos.getAutorizado_por(), aprovacoesCiclos.getStatus_aprovacao(), aprovacoesCiclos.getObservacoes()
        ));
    }
    public AprovacoesCicloDTO aprovacoesCiclosPorId(Long id){
        AprovacoesCiclo ciclo = aprovacoesCicloRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        return new AprovacoesCicloDTO(
                ciclo.getId(), ciclo.getDocumento_id(), ciclo.getCiclo_id(), ciclo.getData_aprovacao(),
                ciclo.getAutorizado_por(), ciclo.getStatus_aprovacao(), ciclo.getObservacoes()
        );
    }
    public void atualizarAprovacaoCiclo(Long id, AprovacoesCicloDTO cicloDTO){
        AprovacoesCiclo ciclo = aprovacoesCicloRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        ciclo.setDocumento_id(cicloDTO.getDocumento_id());
        ciclo.setCiclo_id(cicloDTO.getCiclo_id());
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
