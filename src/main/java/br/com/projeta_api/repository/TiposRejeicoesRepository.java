package br.com.projeta_api.repository;

import br.com.projeta_api.model.TiposRejeicoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposRejeicoesRepository extends JpaRepository<TiposRejeicoes, Long> {
}
