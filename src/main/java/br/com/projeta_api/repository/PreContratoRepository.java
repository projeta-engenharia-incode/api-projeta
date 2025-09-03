package br.com.projeta_api.repository;

import br.com.projeta_api.model.PreContrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PreContratoRepository extends JpaRepository<PreContrato, Long> {
}
