package br.com.mentoria.projeto.controller;

import br.com.mentoria.projeto.dto.request.usuario.CriarUsuarioRequest;
import br.com.mentoria.projeto.dto.request.usuario.LoginUsuarioRequest;
import br.com.mentoria.projeto.dto.response.usuario.LoginUsuarioResponse;
import br.com.mentoria.projeto.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginUsuarioResponse login(@RequestBody LoginUsuarioRequest request) {
        return authService.login(request);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastro(@RequestBody CriarUsuarioRequest request) {
        return authService.cadastro(request);
    }
}
