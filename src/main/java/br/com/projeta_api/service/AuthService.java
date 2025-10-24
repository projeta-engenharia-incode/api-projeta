package br.com.projeta_api.service;


import br.com.projeta_api.dto.LoginRequest;
import br.com.projeta_api.dto.RegisterRequest;
import br.com.projeta_api.dto.UsuarioDTO;
import br.com.projeta_api.model.Usuario;
import br.com.projeta_api.model.enums.Role;
import br.com.projeta_api.repository.UsuarioRepository;
import br.com.projeta_api.security.jwt.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    public AuthService(UsuarioRepository usuarioRepository,
                       PasswordEncoder passwordEncoder,
                       TokenService tokenService, AuthenticationManager authenticationManager) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    public UsuarioDTO register(RegisterRequest request) {

        if (!request.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new RuntimeException("Email inválido");
        }
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setSenha(passwordEncoder.encode(request.getSenha()));
        usuario.setCargo(request.getCargo());
        usuario.setRole(Role.USER);

        usuarioRepository.save(usuario);

        return new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getCargo(), usuario.getRole());
    }

    public String login(LoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha())
            );

            Usuario usuario = (Usuario) authentication.getPrincipal();

            return tokenService.generateToken(usuario);

        } catch (BadCredentialsException ex) {
            throw new RuntimeException("Email ou senha incorretos");
        }
    }

    public Usuario updateRole(Long userId, Role newRole) {
        Usuario usuario = usuarioRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setRole(newRole);
        usuarioRepository.save(usuario);

        return usuario;
    }
}
