package br.com.mentoria.projeto.controller;

import br.com.mentoria.projeto.dto.request.usuario.AlterarSenhaUsuarioRequest;
import br.com.mentoria.projeto.dto.request.usuario.ColocarSaldoUsuarioRequest;
import br.com.mentoria.projeto.dto.request.usuario.CriarUsuarioRequest;
import br.com.mentoria.projeto.dto.response.usuario.AlterarSenhaUsuarioResponse;
import br.com.mentoria.projeto.entity.Usuario;
import br.com.mentoria.projeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PatchMapping("/{id}")
    public AlterarSenhaUsuarioResponse alterarSenha(
            @RequestBody AlterarSenhaUsuarioRequest request,
            @PathVariable String id,
            @RequestHeader("Authorization") String token
    ) {
        return usuarioService.alterarSenha(request, id, token);
    }

    @GetMapping
    public List<Usuario> pegarTodos() {
        return usuarioService.pegarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> pegarPeloId(@PathVariable String id) {
        return usuarioService.pegarPeloId(id);
    }

    @GetMapping("/recomendacoes/{id}")
    public ResponseEntity<?> recomendacoes(@PathVariable String id, @RequestHeader("Authorization") String token) {
        return usuarioService.recomendacoes(id, token);
    }

    @PatchMapping("/saldo")
    public ResponseEntity<?> colocarSaldo(@RequestBody ColocarSaldoUsuarioRequest request, @RequestHeader("Authorization") String token) {
        return usuarioService.colocarSaldo(request, token);
    }

    @PatchMapping("/desativar/{id}")
    public ResponseEntity<?> desativar(@PathVariable String id, @RequestHeader("Authorization") String token) {
        return usuarioService.desativarConta(id, token);
    }

    @PatchMapping("/ativar/{id}")
    public ResponseEntity<?> ativar(@PathVariable String id, @RequestHeader("Authorization") String token) {
        return usuarioService.ativarConta(id, token);
    }
}
