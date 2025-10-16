package br.com.projeta_api.repository;

import br.com.projeta_api.model.UsoRecursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsoRecursosRepository extends JpaRepository<UsoRecursos, Long> {
}
