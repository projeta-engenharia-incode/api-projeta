package br.com.projeta_api.service;

import br.com.projeta_api.model.ResponsaveisDocumento;
import br.com.projeta_api.repository.ResponsaveisDocumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResponsaveisDocumentoService {

    private final ResponsaveisDocumentoRepository responsaveisDocumentoRepository;

    public ResponsaveisDocumento criar(ResponsaveisDocumento responsaveisDocumento){
        return responsaveisDocumentoRepository.save(responsaveisDocumento);
    }

    public List<ResponsaveisDocumento> listarTodos() {
        return responsaveisDocumentoRepository.findAll();
    }

    public ResponsaveisDocumento buscarPorId(Long id){
        return responsaveisDocumentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Responsável por Documento não encontrado com o ID: " + id));
    }

    public ResponsaveisDocumento atualizar(Long id, ResponsaveisDocumento responsaveisDocumento){
        ResponsaveisDocumento responsaveisDocumentoExistente = buscarPorId(id);

        responsaveisDocumentoExistente.setDocumento(responsaveisDocumento.getDocumento());
        responsaveisDocumentoExistente.setUsuario(responsaveisDocumento.getUsuario());
        responsaveisDocumentoExistente.setNome(responsaveisDocumento.getNome());
        responsaveisDocumentoExistente.setFuncao(responsaveisDocumento.getFuncao());

        return responsaveisDocumentoRepository.save(responsaveisDocumentoExistente);
    }

    public void deletar(Long id){
        ResponsaveisDocumento responsaveisDocumento = buscarPorId(id);
        responsaveisDocumentoRepository.deleteById(responsaveisDocumento.getId());
    }

    public boolean existePorId(Long id){
        return responsaveisDocumentoRepository.existsById(id);
    }
}
