package br.com.projeta_api.repository;

import br.com.projeta_api.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    List<Projeto> findByContratoId(Long contratoId);

    List<Projeto> findByStatusGeral(String statusGeral);

    List<Projeto> findByGestorContainingIgnoreCase(String disciplina);

    List<Projeto> findByTituloContainingIgnoreCase(String titulo);
}
