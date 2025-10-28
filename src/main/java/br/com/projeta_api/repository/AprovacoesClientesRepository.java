package br.com.projeta_api.repository;

import br.com.projeta_api.model.AprovacoesClientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AprovacoesClientesRepository extends JpaRepository<AprovacoesClientes, Long> {
}
