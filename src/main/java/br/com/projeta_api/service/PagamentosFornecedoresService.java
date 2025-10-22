package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.PagamentosFornecedoresDTO;
import br.com.projeta_api.model.PagamentosFornecedores;
import br.com.projeta_api.repository.PagamentosFornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class PagamentosFornecedoresService {
    @Autowired
    private PagamentosFornecedoresRepository pagamentosFornecedoresRepository;

    public PagamentosFornecedoresDTO pagamentosFornecedores(PagamentosFornecedoresDTO dto){
        PagamentosFornecedores entity = new PagamentosFornecedores();
        entity.setFornecedorId(dto.getFornecedorId());
        entity.setDocumentoId(dto.getDocumentoId());
        entity.setPercentualPago(dto.getPercentualPago());
        entity.setValorPago(dto.getValorPago());
        entity.setDataPagamento(dto.getDataPagamento());
        pagamentosFornecedoresRepository.save(entity);
        return dto;
    }
    public Stream<PagamentosFornecedoresDTO> listarPagamentosFornecedores(){
        List<PagamentosFornecedores> entity = pagamentosFornecedoresRepository.findAll();
        return entity.stream().map(
                pagamentosFornecedores -> new PagamentosFornecedoresDTO(
                        pagamentosFornecedores.getId(), pagamentosFornecedores.getFornecedorId(), pagamentosFornecedores.getDocumentoId(),
                        pagamentosFornecedores.getPercentualPago(), pagamentosFornecedores.getValorPago(), pagamentosFornecedores.getDataPagamento()
                ));
    }
    public PagamentosFornecedoresDTO pagamentosFornecedoresPorId(Long id){
        PagamentosFornecedores entity = pagamentosFornecedoresRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        return new PagamentosFornecedoresDTO(
                entity.getId(), entity.getFornecedorId(), entity.getDocumentoId(), entity.getPercentualPago(),
                entity.getValorPago(), entity.getDataPagamento()
        );
    }
    public void atualizarPagamentoFornecedor(Long id, PagamentosFornecedoresDTO dto){
        PagamentosFornecedores entity = pagamentosFornecedoresRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        entity.setFornecedorId(dto.getFornecedorId());
        entity.setDocumentoId(dto.getDocumentoId());
        entity.setPercentualPago(dto.getPercentualPago());
        entity.setValorPago(dto.getValorPago());
        entity.setDataPagamento(dto.getDataPagamento());
        pagamentosFornecedoresRepository.save(entity);
    }
    public void deletarPagamentosFornecedores(Long id){
        pagamentosFornecedoresRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
        pagamentosFornecedoresRepository.deleteById(id);
    }
}
