package br.com.projeta_api.repository;

import br.com.projeta_api.model.ResponsaveisDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsaveisDocumentoRepository extends JpaRepository<ResponsaveisDocumento, Long> {
}
