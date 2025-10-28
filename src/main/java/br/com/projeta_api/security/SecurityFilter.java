package br.com.projeta_api.security;


import br.com.projeta_api.model.Usuario;
import br.com.projeta_api.repository.UsuarioRepository;
import br.com.projeta_api.security.jwt.TokenService;
import com.auth0.jwt.exceptions.JWTDecodeException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final UsuarioRepository usuarioRepository;

    private final TokenService tokenService;

    public SecurityFilter(UsuarioRepository usuarioRepository, TokenService tokenService) {
        this.usuarioRepository = usuarioRepository;
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        try {
            String token = this.recoverToken(request);

            if (token != null) {
                String email = tokenService.validateToken(token);

                if (email != null) {
                    Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);

                    if (usuarioOpt.isPresent()) {
                        Usuario usuario = usuarioOpt.get();

                        var authentication = new UsernamePasswordAuthenticationToken(
                                usuario, null, usuario.getAuthorities()
                        );

                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }
            filterChain.doFilter(request, response);

        } catch (JWTDecodeException e) {
            System.out.println("Erro ao decodificar o token: " + e.getMessage());
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            System.out.println("Erro de autenticação: " + e.getMessage());
            filterChain.doFilter(request, response);
        }
    }


    public String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        return path.startsWith("/v3/api-docs")
                || path.startsWith("/swagger-ui")
                || path.startsWith("/swagger-ui.html")
                || path.startsWith("/webjars")
                || path.startsWith("/projeta-api/v3/api-docs")
                || path.startsWith("/projeta-api/swagger-ui")
                || path.startsWith("/projeta-api/swagger-ui.html")
                || path.endsWith(".css")
                || path.endsWith(".js");
    }
}
