package br.com.projeta_api.repository;

import br.com.projeta_api.model.EntregasCiclo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EntregasCicloRepository extends JpaRepository<EntregasCiclo, Long> {

    List<EntregasCiclo> findByDocumentoId(Long documentoId);

    List<EntregasCiclo> findByCicloId(Long cicloId);

    List<EntregasCiclo> findByStatusCobranca(String statusCobranca);

    List<EntregasCiclo> findByDataEmissaoBetween(LocalDate inicio, LocalDate fim);
}
