package br.com.projeta_api.repository;

import br.com.projeta_api.model.Ciclo;
import br.com.projeta_api.model.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecursoRepository extends JpaRepository<Recurso, Long> {

    List<Recurso> findByNomeContainingIgnoreCase(String nome);

    List<Recurso> findByTipoContainingIgnoreCase(String tipo);
}
