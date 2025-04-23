package br.com.mentoria.projeto.controller;

import br.com.mentoria.projeto.dto.request.curso.ComprarCursoRequest;
import br.com.mentoria.projeto.dto.request.curso.CriarCursoRequest;
import br.com.mentoria.projeto.dto.response.curso.CriarCursoResponse;
import br.com.mentoria.projeto.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @PostMapping
    public CriarCursoResponse criarCurso(@RequestBody CriarCursoRequest request, @RequestHeader("Authorization") String token) {
        return cursoService.criarCurso(request, token);
    }

    @PostMapping("/comprar")
    public ResponseEntity<?> comprar(@RequestBody ComprarCursoRequest request, @RequestHeader("Authorization") String token) {
        return cursoService.comprarCurso(request, token);
    }
}
