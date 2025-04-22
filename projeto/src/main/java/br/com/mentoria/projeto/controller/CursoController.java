package br.com.mentoria.projeto.controller;

import br.com.mentoria.projeto.dto.request.CriarCursoRequest;
import br.com.mentoria.projeto.dto.response.CriarCursoResponse;
import br.com.mentoria.projeto.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @PostMapping
    public CriarCursoResponse criarCurso(@RequestBody CriarCursoRequest request) {
        return cursoService.criarCurso(request);
    }
}
