package br.com.projeta_api.repository;

import br.com.projeta_api.model.Cobrancas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CobrancasRepository extends JpaRepository<Cobrancas, Long> {

    List<Cobrancas> findByCicloId(Long cicloId);

    List<Cobrancas> findByClienteContainingIgnoreCase(String cliente);

    List<Cobrancas> findByStatusCobranca(String statusCobranca);

    List<Cobrancas> findByDataEmissaoBetween(LocalDate inicio, LocalDate fim);
}
