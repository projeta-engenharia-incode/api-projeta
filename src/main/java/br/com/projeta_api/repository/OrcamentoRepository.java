package br.com.projeta_api.repository;

import br.com.projeta_api.model.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {

}
