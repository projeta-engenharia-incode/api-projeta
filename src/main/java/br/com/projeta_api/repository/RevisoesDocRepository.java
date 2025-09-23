package br.com.projeta_api.repository;

import br.com.projeta_api.model.RevisoesDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevisoesDocRepository extends JpaRepository<RevisoesDoc, Long> {
}
