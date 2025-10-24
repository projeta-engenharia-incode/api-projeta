package br.com.projeta_api.service;

import br.com.projeta_api.dto.ResponsaveisDocumentoDTO;
import br.com.projeta_api.model.Documentos;
import br.com.projeta_api.model.ResponsaveisDocumento;
import br.com.projeta_api.model.Usuario;
import br.com.projeta_api.repository.DocumentosRepository;
import br.com.projeta_api.repository.ResponsaveisDocumentoRepository;
import br.com.projeta_api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ResponsaveisDocumentoService {

    private final ResponsaveisDocumentoRepository responsaveisDocumentoRepository;

    private final DocumentosRepository documentosRepository;

    private final UsuarioRepository usuarioRepository;

    public ResponsaveisDocumentoService(ResponsaveisDocumentoRepository responsaveisDocumentoRepository, DocumentosRepository documentosRepository, UsuarioRepository usuarioRepository) {
        this.responsaveisDocumentoRepository = responsaveisDocumentoRepository;
        this.documentosRepository = documentosRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<ResponsaveisDocumento> listarTodos() {
        List<ResponsaveisDocumento> lista = responsaveisDocumentoRepository.findAll();

        if (lista.isEmpty()) {
            throw new RuntimeException("Nenhum responsável por documento encontrado.");
        }

        return lista;
    }

    public ResponsaveisDocumentoDTO criar(ResponsaveisDocumentoDTO dto) {
        try {
            ResponsaveisDocumento entity = new ResponsaveisDocumento();
            Documentos doc = documentosRepository.findById(entity.getDocumento().getId()).orElseThrow(() -> new RuntimeException("ERRO"));
            Usuario usuario = usuarioRepository.findById(entity.getUsuario().getId()).orElseThrow(() -> new RuntimeException("ERRO"));
            entity.setDocumento(doc);
            entity.setUsuario(usuario);
            entity.setStatus(dto.getStatus());
            entity.setNome(dto.getNome());
            entity.setFuncao(dto.getFuncao());

            ResponsaveisDocumento savedEntity = responsaveisDocumentoRepository.save(entity);
            dto.setId(savedEntity.getId());

            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar responsável por documento.");
        }
    }

    public ResponsaveisDocumentoDTO atualizar(ResponsaveisDocumentoDTO dto) {
        try {
            ResponsaveisDocumento entity = responsaveisDocumentoRepository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("Responsável por documento não encontrado com ID: " + dto.getId()));

            Documentos docUp = documentosRepository.findById(entity.getDocumento().getId()).orElseThrow(() -> new RuntimeException("ERRO"));
            Usuario usuarioUp = usuarioRepository.findById(entity.getUsuario().getId()).orElseThrow(() -> new RuntimeException("ERRO"));

            entity.setDocumento(docUp);
            entity.setUsuario(usuarioUp);
            entity.setNome(dto.getNome());
            entity.setFuncao(dto.getFuncao());
            entity.setStatus(dto.getStatus());

            ResponsaveisDocumento updated = responsaveisDocumentoRepository.save(entity);

            ResponsaveisDocumentoDTO updatedDto = new ResponsaveisDocumentoDTO();
            updatedDto.setId(updated.getId());
            updatedDto.setDocumentoId(updated.getDocumento().getId());
            updatedDto.setUsuarioId(updated.getUsuario().getId());
            updatedDto.setNome(updated.getNome());
            updatedDto.setFuncao(updated.getFuncao());

            return updatedDto;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar responsável por documento.");
        }
    }

    public ResponsaveisDocumento buscarPorId(Long id) {
        return responsaveisDocumentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Responsável por documento não encontrado com ID: " + id));
    }

    public void deletar(Long id) {
        if (!responsaveisDocumentoRepository.existsById(id)) {
            throw new RuntimeException("Responsável por documento não encontrado com ID: " + id);
        }

        responsaveisDocumentoRepository.deleteById(id);
    }

    public boolean existePorId(Long id) {
        return responsaveisDocumentoRepository.existsById(id);
    }
}
