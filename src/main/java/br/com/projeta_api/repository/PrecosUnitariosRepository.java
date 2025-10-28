package br.com.projeta_api.repository;

import br.com.projeta_api.model.PrecosUnitarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrecosUnitariosRepository extends JpaRepository<PrecosUnitarios, Long> {
    List<PrecosUnitarios> findByContratoId(Long contratoId);
}
