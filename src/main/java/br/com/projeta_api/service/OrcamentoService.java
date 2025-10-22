package br.com.projeta_api.service;

import br.com.projeta_api.dto.OrcamentoDTO;
import br.com.projeta_api.model.Orcamento;
import br.com.projeta_api.repository.ChamadosRepository;
import br.com.projeta_api.repository.OrcamentoRepository;
import br.com.projeta_api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrcamentoService {

    private final OrcamentoRepository orcamentoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ChamadosRepository chamadoRepository;

    public OrcamentoService(OrcamentoRepository orcamentoRepository,
                            UsuarioRepository usuarioRepository,
                            ChamadosRepository chamadoRepository) {
        this.orcamentoRepository = orcamentoRepository;
        this.usuarioRepository = usuarioRepository;
        this.chamadoRepository = chamadoRepository;
    }

    public List<Orcamento> getAllOrcamentos() {
        List<Orcamento> lista = orcamentoRepository.findAll();
        if (lista.isEmpty()) {
            throw new RuntimeException("Nenhum orçamento encontrado.");
        }
        return lista;
    }

    public OrcamentoDTO saveOrcamento(OrcamentoDTO dto) {
        try {
            Orcamento entity = new Orcamento();

            if (dto.getOrcamentistaId() != null) {
                var orcamentista = usuarioRepository.findById(dto.getOrcamentistaId())
                        .orElseThrow(() -> new RuntimeException("Orcamentista não encontrado."));
                entity.setOrcamentista(orcamentista);
            }

            if (dto.getChamadoId() != null) {
                var chamado = chamadoRepository.findById(dto.getChamadoId())
                        .orElseThrow(() -> new RuntimeException("Chamado não encontrado."));
                entity.setChamados(chamado);
            }

            entity.setCodigoOrcamento(dto.getCodigoOrcamento());
            entity.setStatusOrcamento(dto.getStatusOrcamento());
            entity.setNomeOrcamento(dto.getNomeOrcamento());
            entity.setCronograma(dto.isCronograma());
            entity.setCentroDeCusto(dto.getCentroDeCusto());
            entity.setDataEmissao(dto.getDataEmissao());
            entity.setDataRevisao(dto.getDataRevisao());
            entity.setNumeroRevisao(dto.getNumeroRevisao());
            entity.setDataAprovacao(dto.getDataAprovacao());
            entity.setDiasExecucao(dto.getDiasExecucao());
            entity.setDataFinalizacao(dto.getDataFinalizacao());
            entity.setNumeroSe(dto.getNumeroSe());
            entity.setNumeroLd(dto.getNumeroLd());
            entity.setValorOrcado(dto.getValorOrcado());
            entity.setValorAprovado(dto.getValorAprovado());
            entity.setValorPrevisto(dto.getValorPrevisto());
            entity.setPercentualExecucao(dto.getPercentualExecucao());

            Orcamento saved = orcamentoRepository.save(entity);
            dto.setId(saved.getId());
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar orçamento.", e);
        }
    }

    public OrcamentoDTO updateOrcamento(Long id, OrcamentoDTO dto) {
        Orcamento entity = orcamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orçamento não encontrado com ID: " + id));

        if (dto.getOrcamentistaId() != null) {
            var orcamentista = usuarioRepository.findById(dto.getOrcamentistaId())
                    .orElseThrow(() -> new RuntimeException("Orcamentista não encontrado."));
            entity.setOrcamentista(orcamentista);
        }

        if (dto.getChamadoId() != null) {
            var chamado = chamadoRepository.findById(dto.getChamadoId())
                    .orElseThrow(() -> new RuntimeException("Chamado não encontrado."));
            entity.setChamados(chamado);
        }

        entity.setCodigoOrcamento(dto.getCodigoOrcamento());
        entity.setStatusOrcamento(dto.getStatusOrcamento());
        entity.setNomeOrcamento(dto.getNomeOrcamento());
        entity.setCronograma(dto.isCronograma());
        entity.setCentroDeCusto(dto.getCentroDeCusto());
        entity.setDataEmissao(dto.getDataEmissao());
        entity.setDataRevisao(dto.getDataRevisao());
        entity.setNumeroRevisao(dto.getNumeroRevisao());
        entity.setDataAprovacao(dto.getDataAprovacao());
        entity.setDiasExecucao(dto.getDiasExecucao());
        entity.setDataFinalizacao(dto.getDataFinalizacao());
        entity.setNumeroSe(dto.getNumeroSe());
        entity.setNumeroLd(dto.getNumeroLd());
        entity.setValorOrcado(dto.getValorOrcado());
        entity.setValorAprovado(dto.getValorAprovado());
        entity.setValorPrevisto(dto.getValorPrevisto());
        entity.setPercentualExecucao(dto.getPercentualExecucao());

        orcamentoRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public OrcamentoDTO getOrcamentoById(Long id) {
        Orcamento entity = orcamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orçamento não encontrado com ID: " + id));

        OrcamentoDTO dto = new OrcamentoDTO();
        dto.setId(entity.getId());
        dto.setChamadoId(entity.getChamados() != null ? entity.getChamados().getId() : null);
        dto.setOrcamentistaId(entity.getOrcamentista() != null ? entity.getOrcamentista().getId() : null);
        dto.setCodigoOrcamento(entity.getCodigoOrcamento());
        dto.setStatusOrcamento(entity.getStatusOrcamento());
        dto.setNomeOrcamento(entity.getNomeOrcamento());
        dto.setCronograma(entity.isCronograma());
        dto.setCentroDeCusto(entity.getCentroDeCusto());
        dto.setDataEmissao(entity.getDataEmissao());
        dto.setDataRevisao(entity.getDataRevisao());
        dto.setNumeroRevisao(entity.getNumeroRevisao());
        dto.setDataAprovacao(entity.getDataAprovacao());
        dto.setDiasExecucao(entity.getDiasExecucao());
        dto.setDataFinalizacao(entity.getDataFinalizacao());
        dto.setNumeroSe(entity.getNumeroSe());
        dto.setNumeroLd(entity.getNumeroLd());
        dto.setValorOrcado(entity.getValorOrcado());
        dto.setValorAprovado(entity.getValorAprovado());
        dto.setValorPrevisto(entity.getValorPrevisto());
        dto.setPercentualExecucao(entity.getPercentualExecucao());

        return dto;
    }

    public void deleteOrcamento(Long id) {
        if (!orcamentoRepository.existsById(id)) {
            throw new RuntimeException("Orçamento não encontrado com ID: " + id);
        }
        orcamentoRepository.deleteById(id);
    }
}
