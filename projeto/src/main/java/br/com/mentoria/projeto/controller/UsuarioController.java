package br.com.mentoria.projeto.controller;

import br.com.mentoria.projeto.dto.request.AlterarSenhaUsuarioRequest;
import br.com.mentoria.projeto.dto.request.CriarUsuarioRequest;
import br.com.mentoria.projeto.dto.response.AlterarSenhaUsuarioResponse;
import br.com.mentoria.projeto.entity.Usuario;
import br.com.mentoria.projeto.ia.GeminiService;
import br.com.mentoria.projeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> cadastro(@RequestBody CriarUsuarioRequest request) {
        return usuarioService.cadastro(request);
    }

    @PatchMapping("/{id}")
    public AlterarSenhaUsuarioResponse alterarSenha(@RequestBody AlterarSenhaUsuarioRequest request, @PathVariable String id) {
        return usuarioService.alterarSenha(request, id);
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
    public ResponseEntity<?> recomendacoes(@PathVariable String id) {
        return usuarioService.recomendacoes(id);
    }
}
