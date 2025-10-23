package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.PagamentosFornecedoresDTO;
import br.com.projeta_api.model.Documentos;
import br.com.projeta_api.model.Fornecedores;
import br.com.projeta_api.model.PagamentosFornecedores;
import br.com.projeta_api.repository.DocumentosRepository;
import br.com.projeta_api.repository.FornecedoresRepository;
import br.com.projeta_api.repository.PagamentosFornecedoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentosFornecedoresService {
    private final PagamentosFornecedoresRepository pagamentosFornecedoresRepository;

    private final FornecedoresRepository fornecedoresRepository;
    private final DocumentosRepository documentosRepository;

    public PagamentosFornecedoresService(PagamentosFornecedoresRepository pagamentosFornecedoresRepository,  FornecedoresRepository fornecedoresRepository, DocumentosRepository documentosRepository) {
        this.pagamentosFornecedoresRepository = pagamentosFornecedoresRepository;
        this.fornecedoresRepository = fornecedoresRepository;
        this.documentosRepository = documentosRepository;
    }

    public PagamentosFornecedoresDTO savePagamentoFornecedor(PagamentosFornecedoresDTO dto) {
        try {
            PagamentosFornecedores entity = new PagamentosFornecedores();

            Fornecedores fornecedores = fornecedoresRepository.findById(dto.getFornecedorId()).orElse(null);
            Documentos doc = documentosRepository.findById(dto.getDocumentoId()).orElseThrow(() -> new RuntimeException("ERRO"));
            entity.setFornecedores(fornecedores);
            entity.setDocumentos(doc);
            entity.setPercentualPago(dto.getPercentualPago());
            entity.setValorPago(dto.getValorPago());
            entity.setDataPagamento(dto.getDataPagamento());

            PagamentosFornecedores saved = pagamentosFornecedoresRepository.save(entity);
            dto.setId(saved.getId());
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar pagamento do fornecedor." + e.getMessage());
        }
    }

    public List<PagamentosFornecedoresDTO> listarPagamentosFornecedores() {
        List<PagamentosFornecedores> entities = pagamentosFornecedoresRepository.findAll();
        if (entities.isEmpty()) {
            throw new RuntimeException("Nenhum pagamento de fornecedor encontrado.");
        }

        return entities.stream()
                .map(p -> new PagamentosFornecedoresDTO(
                        p.getId(),
                        p.getFornecedores().getId(),
                        p.getDocumentos().getId(),
                        p.getPercentualPago(),
                        p.getValorPago(),
                        p.getDataPagamento()
                ))
                .toList();
    }

    public PagamentosFornecedoresDTO getPagamentoFornecedorById(Long id) {
        PagamentosFornecedores entity = pagamentosFornecedoresRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento de fornecedor não encontrado com ID: " + id));

        return new PagamentosFornecedoresDTO(
                entity.getId(),
                entity.getFornecedores().getId(),
                entity.getDocumentos().getId(),
                entity.getPercentualPago(),
                entity.getValorPago(),
                entity.getDataPagamento()
        );
    }

    public PagamentosFornecedoresDTO updatePagamentoFornecedor(Long id, PagamentosFornecedoresDTO dto) {
        PagamentosFornecedores entity = pagamentosFornecedoresRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento de fornecedor não encontrado com ID: " + id));

        Fornecedores fornecedoresUp = fornecedoresRepository.findById(entity.getFornecedores().getId()).orElse(null);
        Documentos docUp = documentosRepository.findById(entity.getDocumentos().getId()).orElseThrow(() -> new RuntimeException("ERRO"));

        entity.setFornecedores(fornecedoresUp);
        entity.setDocumentos(docUp);
        entity.setPercentualPago(dto.getPercentualPago());
        entity.setValorPago(dto.getValorPago());
        entity.setDataPagamento(dto.getDataPagamento());

        PagamentosFornecedores updated = pagamentosFornecedoresRepository.save(entity);
        dto.setId(updated.getId());
        return dto;
    }

    public void deletePagamentoFornecedor(Long id) {
        if (!pagamentosFornecedoresRepository.existsById(id)) {
            throw new RuntimeException("Pagamento de fornecedor não encontrado com ID: " + id);
        }
        pagamentosFornecedoresRepository.deleteById(id);
    }
}
