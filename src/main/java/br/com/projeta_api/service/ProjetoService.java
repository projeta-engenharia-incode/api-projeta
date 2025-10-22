package br.com.projeta_api.service;

import br.com.projeta_api.model.Projeto;
import br.com.projeta_api.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    public Projeto criarProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public List<Projeto> listarProjeto() {
        return projetoRepository.findAll();
    }

    public Projeto buscarProjetoPorId(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado com o ID: " + id));
    }

   public Projeto atualizarProjeto(Long id, Projeto projetoAtualizado) {
        Projeto projetoExistente = buscarProjetoPorId(id);
        projetoExistente.setTitulo(projetoAtualizado.getTitulo());
        projetoExistente.setDisciplina(projetoAtualizado.getDisciplina());
        projetoExistente.setStatusGeral(projetoAtualizado.getStatusGeral());
        projetoExistente.setContrato(projetoAtualizado.getContrato());
        projetoExistente.setUpdatedAt(projetoAtualizado.getUpdatedAt());

        return projetoRepository.save(projetoExistente);
   }

   public void deletarProjeto(Long id) {
        Projeto projeto = buscarProjetoPorId(id);
        projetoRepository.deleteById(projeto.getId());
    }

    public boolean existeProjetoPorId(Long id) {
        return projetoRepository.existsById(id);
    }
}