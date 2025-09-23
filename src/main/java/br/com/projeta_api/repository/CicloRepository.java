package br.com.projeta_api.repository;

import br.com.projeta_api.model.Ciclo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CicloRepository extends JpaRepository<Ciclo, Long> {

    List<Ciclo> findByNomeContainingIgnoreCase(String nome);
}
