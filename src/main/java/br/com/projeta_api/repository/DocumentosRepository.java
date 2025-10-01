package br.com.projeta_api.repository;

import br.com.projeta_api.model.Documentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentosRepository extends JpaRepository<Documentos, Long> {
}
