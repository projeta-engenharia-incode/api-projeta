package br.com.projeta_api.repository;

import br.com.projeta_api.model.MedicoesDocumentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoesDocumentosRepository extends JpaRepository<MedicoesDocumentos, Long> {
}
