package br.com.projeta_api.repository;

import br.com.projeta_api.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {

    Optional<Contrato> findByCodigo(String codigo);

    Boolean existsByCodigo(String codigo);

    // Buscar contratos ativos em uma data específica
    List<Contrato> findAtivosNaData(LocalDate data);

    // Buscar por empresa
    List<Contrato> findByEmpresaContainingIgnoreCase(String empresa);

    // Buscar por gestor
    List<Contrato> findByGestorContainingIgnoreCase(String gestor);
}
