package br.com.projeta_api.repository;

import br.com.projeta_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //Optional<UserDetails> findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);
}
