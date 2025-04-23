package br.com.mentoria.projeto.service;

import br.com.mentoria.projeto.dto.request.CriarCursoRequest;
import br.com.mentoria.projeto.dto.response.CriarCursoResponse;
import br.com.mentoria.projeto.entity.Curso;
import br.com.mentoria.projeto.entity.Usuario;
import br.com.mentoria.projeto.entity.enums.Papel;
import br.com.mentoria.projeto.mapper.CursoMapper;
import br.com.mentoria.projeto.repository.CursoRepository;
import br.com.mentoria.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;
    public CursoService(
            UsuarioRepository usuarioRepository,
            CursoRepository cursoRepository,
            CursoMapper cursoMapper
    ) {
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
        this.cursoMapper = cursoMapper;
    }

    public CriarCursoResponse criarCurso(CriarCursoRequest request) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByCpf(request.getCpfMentor());
        if (usuarioOptional.isEmpty()) {
            return CriarCursoResponse.builder()
                    .mensagem("Erro ao criar curso!! Usuario nao existe")
                    .build();
        }

        Usuario mentor = usuarioOptional.get();
        if (mentor.getPapel() == Papel.MENTORADO) {
            return CriarCursoResponse.builder()
                    .mensagem("Usuario nao eh mentor!")
                    .build();
        }

        Curso curso = cursoMapper.entidadeCurso(request);
        if (curso == null) {
            return CriarCursoResponse.builder()
                    .mensagem("Erro ao criar curso! Dados inválidos.")
                    .build();
        }

        mentor.getCursos().add(curso);
        cursoRepository.save(curso);
        usuarioRepository.save(mentor);

        return CriarCursoResponse.builder()
                .id(curso.getId())
                .titulo(curso.getTitulo())
                .descricao(curso.getDescricao())
                .mensagem("Curso salvo com sucesso na conta do mentor!")
                .build();
    }
}
