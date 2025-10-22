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

    public DocumentosService(DocumentosRepository documentosRepository) {
        this.documentosRepository = documentosRepository;
    }

    public DocumentosDTO criarDocumento(DocumentosDTO dto) {
        try {
            Documentos entity = new Documentos();
            entity.setProjetoId(dto.getProjetoId());
            entity.setCicloId(dto.getCicloId());
            entity.setCodigoDoc(dto.getCodigoDoc());
            entity.setTituloSecundario(dto.getTituloSecundario());
            entity.setTipo(dto.getTipo());
            entity.setFormato(dto.getFormato());
            entity.setCategoria(dto.getCategoria());
            entity.setDescricao(dto.getDescricao());
            entity.setStatusDocumento(dto.getStatusDocumento());
            entity.setEtapa(dto.getEtapa());
            entity.setResponsavel(dto.getResponsavel());
            entity.setAuxiliar(dto.getAuxiliar());
            entity.setNumProjeta(dto.getNumProjeta());
            entity.setNumCliente(dto.getNumCliente());
            entity.setNumSe(dto.getNumSe());
            entity.setDatas(dto.getDatas());
            entity.setQtdPrevista(dto.getQtdPrevista());
            entity.setMultiplicador(dto.getMultiplicador());
            entity.setItemQqf(dto.getItemQqf());
            entity.setEquivalentePrevisto(dto.getEquivalentePrevisto());
            entity.setEquivalenteEntregue(dto.getEquivalenteEntregue());
            entity.setValorUnitario(dto.getValorUnitario());
            entity.setValorPrevisto(dto.getValorPrevisto());
            entity.setValorEntregue(dto.getValorEntregue());
            entity.setValorReajustado(dto.getValorReajustado());
            entity.setPercentualExecucao(dto.getPercentualExecucao());
            entity.setObservacao(dto.getObservacao());
            entity.setCreatedAt(dto.getCreatedAt());
            entity.setUpdatedAt(dto.getUpdatedAt());

            Documentos saved = documentosRepository.save(entity);
            dto.setId(saved.getId());
            return dto;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar documento.", e);
        }
    }

    public List<DocumentosDTO> listarDocumentos() {
        List<Documentos> entities = documentosRepository.findAll();

        if (entities.isEmpty()) {
            throw new RuntimeException("Nenhum documento encontrado.");
        }

        return entities.stream()
                .map(doc -> new DocumentosDTO(
                        doc.getId(),
                        doc.getProjetoId(),
                        doc.getCicloId(),
                        doc.getCodigoDoc(),
                        doc.getTituloSecundario(),
                        doc.getTipo(),
                        doc.getFormato(),
                        doc.getCategoria(),
                        doc.getDescricao(),
                        doc.getStatusDocumento(),
                        doc.getEtapa(),
                        doc.getResponsavel(),
                        doc.getAuxiliar(),
                        doc.getNumProjeta(),
                        doc.getNumCliente(),
                        doc.getNumSe(),
                        doc.getDatas(),
                        doc.getQtdPrevista(),
                        doc.getMultiplicador(),
                        doc.getItemQqf(),
                        doc.getEquivalentePrevisto(),
                        doc.getEquivalenteEntregue(),
                        doc.getValorUnitario(),
                        doc.getValorPrevisto(),
                        doc.getValorEntregue(),
                        doc.getValorReajustado(),
                        doc.getPercentualExecucao(),
                        doc.getObservacao(),
                        doc.getCreatedAt(),
                        doc.getUpdatedAt()
                ))
                .toList();
    }

    public DocumentosDTO documentosPorId(Long id) {
        Documentos entity = documentosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento não encontrado com o ID: " + id));

        return new DocumentosDTO(
                entity.getId(),
                entity.getProjetoId(),
                entity.getCicloId(),
                entity.getCodigoDoc(),
                entity.getTituloSecundario(),
                entity.getTipo(),
                entity.getFormato(),
                entity.getCategoria(),
                entity.getDescricao(),
                entity.getStatusDocumento(),
                entity.getEtapa(),
                entity.getResponsavel(),
                entity.getAuxiliar(),
                entity.getNumProjeta(),
                entity.getNumCliente(),
                entity.getNumSe(),
                entity.getDatas(),
                entity.getQtdPrevista(),
                entity.getMultiplicador(),
                entity.getItemQqf(),
                entity.getEquivalentePrevisto(),
                entity.getEquivalenteEntregue(),
                entity.getValorUnitario(),
                entity.getValorPrevisto(),
                entity.getValorEntregue(),
                entity.getValorReajustado(),
                entity.getPercentualExecucao(),
                entity.getObservacao(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public DocumentosDTO atualizarDocumento(Long id, DocumentosDTO dto) {
        try {
            Documentos entity = documentosRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Documento não encontrado com o ID: " + id));

            entity.setProjetoId(dto.getProjetoId());
            entity.setCicloId(dto.getCicloId());
            entity.setCodigoDoc(dto.getCodigoDoc());
            entity.setTituloSecundario(dto.getTituloSecundario());
            entity.setTipo(dto.getTipo());
            entity.setFormato(dto.getFormato());
            entity.setCategoria(dto.getCategoria());
            entity.setDescricao(dto.getDescricao());
            entity.setStatusDocumento(dto.getStatusDocumento());
            entity.setEtapa(dto.getEtapa());
            entity.setResponsavel(dto.getResponsavel());
            entity.setAuxiliar(dto.getAuxiliar());
            entity.setNumProjeta(dto.getNumProjeta());
            entity.setNumCliente(dto.getNumCliente());
            entity.setNumSe(dto.getNumSe());
            entity.setDatas(dto.getDatas());
            entity.setQtdPrevista(dto.getQtdPrevista());
            entity.setMultiplicador(dto.getMultiplicador());
            entity.setItemQqf(dto.getItemQqf());
            entity.setEquivalentePrevisto(dto.getEquivalentePrevisto());
            entity.setEquivalenteEntregue(dto.getEquivalenteEntregue());
            entity.setValorUnitario(dto.getValorUnitario());
            entity.setValorPrevisto(dto.getValorPrevisto());
            entity.setValorEntregue(dto.getValorEntregue());
            entity.setValorReajustado(dto.getValorReajustado());
            entity.setPercentualExecucao(dto.getPercentualExecucao());
            entity.setObservacao(dto.getObservacao());
            entity.setCreatedAt(dto.getCreatedAt());
            entity.setUpdatedAt(dto.getUpdatedAt());

            Documentos updated = documentosRepository.save(entity);
            dto.setId(updated.getId());
            return dto;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar documento.", e);
        }
    }

    public void deletarDocumento(Long id) {
        if (!documentosRepository.existsById(id)) {
            throw new RuntimeException("Documento não encontrado com o ID: " + id);
        }
        documentosRepository.deleteById(id);
    }
}
