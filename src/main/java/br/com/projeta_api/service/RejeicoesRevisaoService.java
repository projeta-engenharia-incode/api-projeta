package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.RejeicoesRevisaoDTO;
import br.com.projeta_api.model.RejeicoesRevisao;
import br.com.projeta_api.model.RevisoesDoc;
import br.com.projeta_api.model.TiposRejeicoes;
import br.com.projeta_api.repository.RejeicoesRevisaoRepository;
import br.com.projeta_api.repository.RevisoesDocRepository;
import br.com.projeta_api.repository.TiposRejeicoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RejeicoesRevisaoService {

    private final RejeicoesRevisaoRepository rejeicoesRevisaoRepository;
    private final TiposRejeicoesRepository tiposRejeicoesRepository;

    private final RevisoesDocRepository revisoesDocRepository;

    public RejeicoesRevisaoService(RejeicoesRevisaoRepository rejeicoesRevisaoRepository, TiposRejeicoesRepository tiposRejeicoesRepository, RevisoesDocRepository revisoesDocRepository) {
        this.rejeicoesRevisaoRepository = rejeicoesRevisaoRepository;
        this.tiposRejeicoesRepository = tiposRejeicoesRepository;
        this.revisoesDocRepository = revisoesDocRepository;
    }

    public List<RejeicoesRevisao> getAllRejeicoesRevisao() {
        List<RejeicoesRevisao> lista = rejeicoesRevisaoRepository.findAll();
        if (lista.isEmpty()) {
            throw new RuntimeException("Nenhuma rejeição de revisão encontrada.");
        }
        return lista;
    }

    public RejeicoesRevisaoDTO saveRejeicaoRevisao(RejeicoesRevisaoDTO dto) {
        try {

            RejeicoesRevisao entity = new RejeicoesRevisao();

            TiposRejeicoes tiposRej = tiposRejeicoesRepository.findById(dto.getTiposRejeicoesId()).orElseThrow(() -> new RuntimeException("ERRO"));
            RevisoesDoc revisoesDoc = revisoesDocRepository.findById(dto.getRevisoesDocId()).orElseThrow(() -> new RuntimeException("ERRO"));

            entity.setTiposRejeicoes(tiposRej);
            entity.setRevisoesDoc(revisoesDoc);

            RejeicoesRevisao savedEntity = rejeicoesRevisaoRepository.save(entity);
            dto.setId(savedEntity.getId());
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar rejeição de revisão." + e.getMessage());
        }
    }

    public RejeicoesRevisaoDTO updateRejeicaoRevisao(RejeicoesRevisaoDTO dto) {
        try {
            RejeicoesRevisao entity = rejeicoesRevisaoRepository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("Rejeição de revisão não encontrada com o ID: " + dto.getId()));

            TiposRejeicoes tiposRejUp = tiposRejeicoesRepository.findById(entity.getTiposRejeicoes().getId()).orElseThrow(() -> new RuntimeException("ERRO"));
            RevisoesDoc revisoesDocUp = revisoesDocRepository.findById(entity.getRevisoesDoc().getId()).orElseThrow(() -> new RuntimeException("ERRO"));

            entity.setTiposRejeicoes(tiposRejUp);
            entity.setRevisoesDoc(revisoesDocUp);

            rejeicoesRevisaoRepository.save(entity);
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar rejeição de revisão.", e);
        }
    }

    public RejeicoesRevisao getRejeicaoRevisaoById(Long id) {
        return rejeicoesRevisaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rejeição de revisão não encontrada com o ID: " + id));
    }

    public void deleteRejeicaoRevisao(Long id) {
        if (!rejeicoesRevisaoRepository.existsById(id)) {
            throw new RuntimeException("Rejeição de revisão não encontrada com o ID: " + id);
        }
        rejeicoesRevisaoRepository.deleteById(id);
    }

}
