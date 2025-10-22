package br.com.projeta_api.repository;

import br.com.projeta_api.model.Chamados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ChamadosRepository extends JpaRepository<Chamados, Long> {


}
