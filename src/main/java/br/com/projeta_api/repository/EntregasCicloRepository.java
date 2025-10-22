package br.com.projeta_api.repository;

import br.com.projeta_api.model.EntregasCiclo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregasCicloRepository extends JpaRepository<EntregasCiclo, Long> {


}
