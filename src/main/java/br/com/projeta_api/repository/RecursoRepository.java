package br.com.projeta_api.repository;

import br.com.projeta_api.model.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Long> {

    List<Recurso> findByNomeContainingIgnoreCase(String nome);

    List<Recurso> findByTipoContainingIgnoreCase(String tipo);
}
