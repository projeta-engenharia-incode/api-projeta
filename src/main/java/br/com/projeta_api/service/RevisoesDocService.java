package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.RevisoesDocDTO;
import br.com.projeta_api.model.RevisoesDoc;
import br.com.projeta_api.repository.RevisoesDocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class RevisoesDocService {

    private final RevisoesDocRepository revisoesDocRepository;

    public RevisoesDocService(RevisoesDocRepository revisoesDocRepository) {
        this.revisoesDocRepository = revisoesDocRepository;
    }

    public RevisoesDocDTO revisaoDoc(RevisoesDocDTO revisoesDocDTO){
        RevisoesDoc entity = new RevisoesDoc();
        entity.setRevisao(revisoesDocDTO.getRevisao());
        entity.setResponsavel(revisoesDocDTO.getResponsavel());
        entity.setDataEnvio(revisoesDocDTO.getDataEnvio());
        entity.setDataRespostaCiclo(revisoesDocDTO.getDataRespostaCiclo());
        entity.setStatusRevisao(revisoesDocDTO.getStatusRevisao());
        entity.setObservacoes(revisoesDocDTO.getObservacoes());
        revisoesDocRepository.save(entity);
        return revisoesDocDTO;
    }
    public Stream<RevisoesDocDTO> listarRevisoesDocs(){
        List<RevisoesDoc> entity = revisoesDocRepository.findAll();
        return entity.stream().map(revisoesDocs -> new RevisoesDocDTO(
                revisoesDocs.getId(), revisoesDocs.getRevisao(), revisoesDocs.getResponsavel(), revisoesDocs.getDataEnvio(),
                revisoesDocs.getDataRespostaCiclo(), revisoesDocs.getStatusRevisao(), revisoesDocs.getObservacoes()

        ));
    }
    public RevisoesDocDTO revisoesDocsPorId(Long id){
        RevisoesDoc entity = revisoesDocRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        return new RevisoesDocDTO(
                entity.getId(), entity.getRevisao(), entity.getResponsavel(), entity.getDataEnvio(),
                entity.getDataRespostaCiclo(), entity.getStatusRevisao(), entity.getObservacoes()
        );
    }
    public void atualizarRevisaoDoc(Long id, RevisoesDocDTO revisoesDocDTO){
        RevisoesDoc entity = revisoesDocRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        entity.setRevisao(revisoesDocDTO.getRevisao());
        entity.setResponsavel(revisoesDocDTO.getResponsavel());
        entity.setDataEnvio(revisoesDocDTO.getDataEnvio());
        entity.setDataRespostaCiclo(revisoesDocDTO.getDataRespostaCiclo());
        entity.setStatusRevisao(revisoesDocDTO.getStatusRevisao());
        entity.setObservacoes(revisoesDocDTO.getObservacoes());
        revisoesDocRepository.save(entity);
    }
    public void deleteRevisaoDoc(Long id){
      revisoesDocRepository.findById(id)
              .orElseThrow(() -> new RuntimeException("id não encontrado"));
      revisoesDocRepository.deleteById(id);
    }
}
