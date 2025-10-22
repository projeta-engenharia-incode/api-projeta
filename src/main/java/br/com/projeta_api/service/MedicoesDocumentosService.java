package br.com.projeta_api.service;

import br.com.projeta_api.model.MedicoesDocumentos;
import br.com.projeta_api.repository.MedicoesDocumentosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoesDocumentosService {

    private final MedicoesDocumentosRepository medicoesDocumentosRepository;

    public MedicoesDocumentos criar(MedicoesDocumentos medicoesDocumentos){
        return medicoesDocumentosRepository.save(medicoesDocumentos);
    }

    public List<MedicoesDocumentos> listar(){
        return medicoesDocumentosRepository.findAll();
    }

    public MedicoesDocumentos buscarPorId(Long id){
        return medicoesDocumentosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Boletim não encontrado com ID: " + id));
    }

    public MedicoesDocumentos atualizar(Long id, MedicoesDocumentos medicoesDocumentos){
        MedicoesDocumentos medicoesDocumentosExistente = buscarPorId(id);

        medicoesDocumentosExistente.setDocumento(medicoesDocumentos.getDocumento());
        medicoesDocumentosExistente.setCiclo(medicoesDocumentos.getCiclo());
        medicoesDocumentosExistente.setNumeroBoletim(medicoesDocumentos.getNumeroBoletim());
        medicoesDocumentosExistente.setRevisaoBoletim(medicoesDocumentos.getRevisaoBoletim());
        medicoesDocumentosExistente.setQuantidade(medicoesDocumentos.getQuantidade());
        medicoesDocumentosExistente.setValorUnitario(medicoesDocumentos.getValorUnitario());
        medicoesDocumentosExistente.setValorTotal(medicoesDocumentos.getValorTotal());
        medicoesDocumentosExistente.setValorMedido(medicoesDocumentos.getValorMedido());
        medicoesDocumentosExistente.setPercentualRevisao(medicoesDocumentos.getPercentualRevisao());
        medicoesDocumentosExistente.setCreatedAt(medicoesDocumentos.getCreatedAt());

        return medicoesDocumentosRepository.save(medicoesDocumentosExistente);
    }

    public void deletar(Long id){
        MedicoesDocumentos medicoesDocumentos = buscarPorId(id);
        medicoesDocumentosRepository.deleteById(medicoesDocumentos.getId());
    }

    public boolean existePorId(Long id){
        return medicoesDocumentosRepository.existsById(id);
    }
}