package br.com.projeta_api.repository;

import br.com.projeta_api.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {


}
