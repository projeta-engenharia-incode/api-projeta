package br.com.projeta_api.repository;

import br.com.projeta_api.model.AprovacoesCiclo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AprovacoesCicloRepository extends JpaRepository<AprovacoesCiclo, Long> {
}
