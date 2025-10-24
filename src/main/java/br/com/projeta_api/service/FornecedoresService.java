package br.com.projeta_api.service;

import br.com.projeta_api.DTO.request.FornecedoresDTO;
import br.com.projeta_api.model.Contrato;
import br.com.projeta_api.model.Fornecedores;
import br.com.projeta_api.repository.ContratoRepository;
import br.com.projeta_api.repository.FornecedoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class FornecedoresService {

    private final FornecedoresRepository fornecedoresRepository;

    private final ContratoRepository  contratoRepository;

    public FornecedoresService(FornecedoresRepository fornecedoresRepository,  ContratoRepository contratoRepository) {
        this.fornecedoresRepository = fornecedoresRepository;
        this.contratoRepository = contratoRepository;
    }

    public FornecedoresDTO criarFornecedor(FornecedoresDTO fornecedoresDTO) {
        try {
            Fornecedores entity = new Fornecedores();
            Contrato contrato = contratoRepository.findById(fornecedoresDTO.getContratoId()).orElseThrow(() -> new RuntimeException("ERRO"));
            entity.setContrato(contrato);
            entity.setNome(fornecedoresDTO.getNome());
            entity.setTipo(fornecedoresDTO.getTipo());
            fornecedoresRepository.save(entity);
            fornecedoresDTO.setId(entity.getId());
            return fornecedoresDTO;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar fornecedor." + e.getMessage());
        }
    }

    public Stream<FornecedoresDTO> listarFornecedores() {
        List<Fornecedores> entity = fornecedoresRepository.findAll();
        if (entity.isEmpty()) {
            throw new RuntimeException("Nenhum fornecedor encontrado.");
        }
        return entity.stream().map(fornecedores -> new FornecedoresDTO(
                fornecedores.getId(),
                fornecedores.getContrato().getId(),
                fornecedores.getNome(),
                fornecedores.getTipo()
        ));
    }

    public FornecedoresDTO fornecedorPorId(Long id) {
        Fornecedores entity = fornecedoresRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado com o ID: " + id));
        return new FornecedoresDTO(
                entity.getId(),
                entity.getContrato().getId(),
                entity.getNome(),
                entity.getTipo()
        );
    }

    public FornecedoresDTO atualizarFornecedor(Long id, FornecedoresDTO fornecedoresDTO) {
        try {
            Fornecedores entity = fornecedoresRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado com o ID: " + id));

            Contrato contratoUp = contratoRepository.findById(fornecedoresDTO.getContratoId()).orElseThrow(() -> new RuntimeException("ERRO"));
            entity.setContrato(contratoUp);
            entity.setNome(fornecedoresDTO.getNome());
            entity.setTipo(fornecedoresDTO.getTipo());
            fornecedoresRepository.save(entity);
            return fornecedoresDTO;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar fornecedor." + e.getMessage());
        }
    }

    public void deletarFornecedor(Long id) {
        if (!fornecedoresRepository.existsById(id)) {
            throw new RuntimeException("Fornecedor não encontrado com o ID: " + id);
        }
        fornecedoresRepository.deleteById(id);
    }
}
