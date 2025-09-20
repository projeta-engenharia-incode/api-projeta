package br.com.projeta_api.repository;

import br.com.projeta_api.model.EmissoesDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmissoesDocumentoRepository extends JpaRepository<EmissoesDocumento, Long> {
}
