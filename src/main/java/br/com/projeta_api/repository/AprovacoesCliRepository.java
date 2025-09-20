package br.com.projeta_api.repository;

import br.com.projeta_api.model.AprovacoesCli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AprovacoesCliRepository extends JpaRepository<AprovacoesCli, Long> {
}
