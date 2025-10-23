package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.DocumentosDTO;
import br.com.projeta_api.model.Ciclo;
import br.com.projeta_api.model.Documentos;
import br.com.projeta_api.model.Projeto;
import br.com.projeta_api.repository.CicloRepository;
import br.com.projeta_api.repository.DocumentosRepository;
import br.com.projeta_api.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentosService {

    private final DocumentosRepository documentosRepository;

    private final ProjetoRepository projetoRepository;

    private final CicloRepository cicloRepository;

    public DocumentosService(DocumentosRepository documentosRepository,  ProjetoRepository projetoRepository,  CicloRepository cicloRepository) {
        this.documentosRepository = documentosRepository;
        this.projetoRepository = projetoRepository;
        this.cicloRepository = cicloRepository;
    }

    public DocumentosDTO criarDocumento(DocumentosDTO dto) {
        try {
            Documentos entity = new Documentos();
//            Projeto projeto = projetoRepository.findById(dto.getProjetoId()).orElseThrow(()-> new RuntimeException("ERRO"));
//            Ciclo ciclo = cicloRepository.findById(dto.getCicloId()).orElseThrow(()-> new RuntimeException("ERRO"));
//            entity.setProjetoId(projeto);
//            entity.setCicloId(ciclo);
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
            throw new RuntimeException("Erro ao criar documento." + e.getMessage());
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
                        doc.getProjetoId().getId(),
                        doc.getCicloId().getId(),
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
                entity.getProjetoId().getId(),
                entity.getCicloId().getId(),
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

            Projeto projetoUp = projetoRepository.findById(dto.getProjetoId()).orElseThrow(()-> new RuntimeException("ERRO"));
            Ciclo cicloUp = cicloRepository.findById(dto.getCicloId()).orElseThrow(()-> new RuntimeException("ERRO"));

            entity.setProjetoId(projetoUp);
            entity.setCicloId(cicloUp);
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
