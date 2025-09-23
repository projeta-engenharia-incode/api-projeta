package br.com.projeta_api.repository;

import br.com.projeta_api.model.Fornecedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedoresRepository extends JpaRepository<Fornecedores, Long> {
}
