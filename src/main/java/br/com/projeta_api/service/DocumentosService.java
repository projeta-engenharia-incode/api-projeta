package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.DocumentosDTO;
import br.com.projeta_api.model.Documentos;
import br.com.projeta_api.repository.DocumentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class DocumentosService {

    private final DocumentosRepository documentosRepository;

    public DocumentosService(DocumentosRepository documentosRepository){
        this.documentosRepository = documentosRepository;
    }

    public DocumentosDTO documento(DocumentosDTO documentosDTO){
        Documentos entity = new Documentos();
        entity.setProjetoId(documentosDTO.getProjetoId());
        entity.setCicloId(documentosDTO.getCicloId());
        entity.setCodigoDoc(documentosDTO.getCodigoDoc());
        entity.setTituloSecundario(documentosDTO.getTituloSecundario());
        entity.setTipo(documentosDTO.getTipo());
        entity.setFormato(documentosDTO.getFormato());
        entity.setCategoria(documentosDTO.getCategoria());
        entity.setDescricao(documentosDTO.getDescricao());
        entity.setStatusDocumento(documentosDTO.getStatusDocumento());
        entity.setEtapa(documentosDTO.getEtapa());
        entity.setResponsavel(documentosDTO.getResponsavel());
        entity.setAuxiliar(documentosDTO.getAuxiliar());
        entity.setNumProjeta(documentosDTO.getNumProjeta());
        entity.setNumCliente(documentosDTO.getNumCliente());
        entity.setNumSe(documentosDTO.getNumSe());
        entity.setDatas(documentosDTO.getDatas());
        entity.setQtdPrevista(documentosDTO.getQtdPrevista());
        entity.setMultiplicador(documentosDTO.getMultiplicador());
        entity.setItemQqf(documentosDTO.getItemQqf());
        entity.setEquivalentePrevisto(documentosDTO.getEquivalentePrevisto());
        entity.setEquivalenteEntregue(documentosDTO.getEquivalenteEntregue());
        entity.setValorUnitario(documentosDTO.getValorUnitario());
        entity.setValorPrevisto(documentosDTO.getValorPrevisto());
        entity.setValorPrevisto(documentosDTO.getValorPrevisto());
        entity.setValorReajustado(documentosDTO.getValorReajustado());
        entity.setPercentualExecucao(documentosDTO.getPercentualExecucao());
        entity.setObservacao(documentosDTO.getObservacao());
        entity.setCreatedAt(documentosDTO.getCreatedAt());
        entity.setUpdatedAt(documentosDTO.getUpdatedAt());
        documentosRepository.save(entity);
        return documentosDTO;
    }

    public Stream<DocumentosDTO> listarDocumentos(){
        List<Documentos> entity = documentosRepository.findAll();
        return entity.stream().map(documentos -> new DocumentosDTO(
                documentos.getId(), documentos.getProjetoId(), documentos.getCicloId(), documentos.getCodigoDoc(), documentos.getTituloSecundario(),
                documentos.getTipo(), documentos.getFormato(), documentos.getCategoria(), documentos.getDescricao(), documentos.getStatusDocumento(),
                documentos.getEtapa(), documentos.getResponsavel(), documentos.getAuxiliar(), documentos.getNumProjeta(), documentos.getNumCliente(),
                documentos.getNumSe(), documentos.getDatas(), documentos.getQtdPrevista(), documentos.getMultiplicador(), documentos.getItemQqf(),
                documentos.getEquivalentePrevisto(), documentos.getEquivalenteEntregue(), documentos.getValorUnitario(), documentos.getValorPrevisto(),
                documentos.getValorEntregue(), documentos.getValorReajustado(), documentos.getPercentualExecucao(), documentos.getObservacao(),
                documentos.getCreatedAt(), documentos.getUpdatedAt()
        ));
    }
    public DocumentosDTO documentosPorId(Long id){
        Documentos entity = documentosRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        return new DocumentosDTO(
                entity.getId(), entity.getProjetoId(), entity.getCicloId(), entity.getCodigoDoc(), entity.getTituloSecundario(),
                entity.getTipo(), entity.getFormato(), entity.getCategoria(), entity.getDescricao(), entity.getStatusDocumento(),
                entity.getEtapa(), entity.getResponsavel(), entity.getAuxiliar(), entity.getNumProjeta(), entity.getNumCliente(),
                entity.getNumSe(), entity.getDatas(), entity.getQtdPrevista(), entity.getMultiplicador(), entity.getItemQqf(),
                entity.getEquivalentePrevisto(), entity.getEquivalenteEntregue(), entity.getValorUnitario(), entity.getValorPrevisto(),
                entity.getValorEntregue(), entity.getValorReajustado(), entity.getPercentualExecucao(), entity.getObservacao(),
                entity.getCreatedAt(), entity.getUpdatedAt()
        );
    }
    public void atualizarDocumento(Long id, DocumentosDTO documentosDTO){
        Documentos entity = documentosRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        entity.setProjetoId(documentosDTO.getProjetoId());
        entity.setCicloId(documentosDTO.getCicloId());
        entity.setCodigoDoc(documentosDTO.getCodigoDoc());
        entity.setTituloSecundario(documentosDTO.getTituloSecundario());
        entity.setTipo(documentosDTO.getTipo());
        entity.setFormato(documentosDTO.getFormato());
        entity.setCategoria(documentosDTO.getCategoria());
        entity.setDescricao(documentosDTO.getDescricao());
        entity.setStatusDocumento(documentosDTO.getStatusDocumento());
        entity.setEtapa(documentosDTO.getEtapa());
        entity.setResponsavel(documentosDTO.getResponsavel());
        entity.setAuxiliar(documentosDTO.getAuxiliar());
        entity.setNumProjeta(documentosDTO.getNumProjeta());
        entity.setNumCliente(documentosDTO.getNumCliente());
        entity.setNumSe(documentosDTO.getNumSe());
        entity.setDatas(documentosDTO.getDatas());
        entity.setQtdPrevista(documentosDTO.getQtdPrevista());
        entity.setMultiplicador(documentosDTO.getMultiplicador());
        entity.setItemQqf(documentosDTO.getItemQqf());
        entity.setEquivalenteEntregue(documentosDTO.getEquivalenteEntregue());
        entity.setValorUnitario(documentosDTO.getValorUnitario());
        entity.setValorPrevisto(documentosDTO.getValorPrevisto());
        entity.setValorEntregue(documentosDTO.getValorEntregue());
        entity.setValorReajustado(documentosDTO.getValorReajustado());
        entity.setPercentualExecucao(documentosDTO.getPercentualExecucao());
        entity.setObservacao(documentosDTO.getObservacao());
        entity.setCreatedAt(documentosDTO.getCreatedAt());
        entity.setUpdatedAt(documentosDTO.getUpdatedAt());
    }
    public void deletarDocumento(Long id){
        documentosRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        documentosRepository.deleteById(id);
    }
}
