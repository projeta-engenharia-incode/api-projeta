package br.com.projeta_api.repository;

import br.com.projeta_api.model.AprovacaoCiclo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AprovacaoCicloRepository extends JpaRepository<AprovacaoCiclo, Long> {

    List<AprovacaoCiclo> findByDocumentoId(Long documentoId);

    List<AprovacaoCiclo> findByCicloId(Long cicloId);

    List<AprovacaoCiclo> findByStatusAprovacao(String statusAprovacao);

    List<AprovacaoCiclo> findByDataAprovacaoBetween(java.time.LocalDate inicio, java.time.LocalDate fim);

}
