package br.com.projeta_api.repository;

import br.com.projeta_api.model.PreContrato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreContratoRepository extends JpaRepository<PreContrato, Long> {

    List<PreContrato> findByStatus(String status);

    List<PreContrato> findByTituloContainingIgnoreCase(String titulo);

    List<PreContrato> findByChamadoId(Long chamadoId);
}
