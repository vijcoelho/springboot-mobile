package br.com.mentoria.projeto.service;

import br.com.mentoria.projeto.config.JwtService;
import br.com.mentoria.projeto.dto.request.usuario.CriarUsuarioRequest;
import br.com.mentoria.projeto.dto.request.usuario.LoginUsuarioRequest;
import br.com.mentoria.projeto.dto.response.usuario.LoginUsuarioResponse;
import br.com.mentoria.projeto.entity.Usuario;
import br.com.mentoria.projeto.mapper.UsuarioMapper;
import br.com.mentoria.projeto.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UsuarioMapper usuarioMapper;

    public AuthService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtService jwtService,
            UsuarioMapper usuarioMapper
    ) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.usuarioMapper = usuarioMapper;
    }

    public LoginUsuarioResponse login(LoginUsuarioRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha())
        );
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow();
        if (!passwordEncoder.matches(request.getSenha(), usuario.getSenha())) {
            return LoginUsuarioResponse.builder()
                    .id(usuario.getId())
                    .mensagem("Login nao efetuado com sucesso, tente novamente!")
                    .token("")
                    .build();
        }
        String token = jwtService.generateToken(usuario);

        return LoginUsuarioResponse.builder()
                .id(usuario.getId())
                .mensagem("Login efetuado com sucesso, segue abaixo o token jwt")
                .token(token)
                .build();
    }

    public ResponseEntity<?> cadastro(CriarUsuarioRequest request) {
        Usuario usuario = usuarioMapper.entidadeCadastro(request);
        if (usuario != null) {
            usuario.setSenha(passwordEncoder.encode(request.getSenha()));
            usuarioRepository.save(usuario);
            return ResponseEntity.status(200).body("Usuario salvo com sucesso");
        }
        return ResponseEntity.status(400).body("Nao foi possivel salver usuario");
    }
}
