package br.com.mentoria.projeto.service;

import br.com.mentoria.projeto.config.JwtService;
import br.com.mentoria.projeto.dto.request.curso.ComprarCursoRequest;
import br.com.mentoria.projeto.dto.request.curso.CriarCursoRequest;
import br.com.mentoria.projeto.dto.response.curso.CriarCursoResponse;
import br.com.mentoria.projeto.entity.Curso;
import br.com.mentoria.projeto.entity.Usuario;
import br.com.mentoria.projeto.entity.enums.Papel;
import br.com.mentoria.projeto.mapper.CursoMapper;
import br.com.mentoria.projeto.repository.CursoRepository;
import br.com.mentoria.projeto.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoService {
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;
    private final JwtService jwtService;

    public CursoService(
            UsuarioRepository usuarioRepository,
            CursoRepository cursoRepository,
            CursoMapper cursoMapper, JwtService jwtService
    ) {
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
        this.cursoMapper = cursoMapper;
        this.jwtService = jwtService;
    }

    public CriarCursoResponse criarCurso(CriarCursoRequest request, String token) {
        String jwtToken = token.replace("Bearer ", "");
        String jwtEmail = jwtService.extractEmail(jwtToken);
        Optional<Usuario> usuarioOptional = usuarioRepository.findByCpf(request.getCpfMentor());
        if (usuarioOptional.isEmpty()) {
            return CriarCursoResponse.builder()
                    .mensagem("Erro ao criar curso!! Usuario nao existe")
                    .build();
        }

        Usuario mentor = usuarioOptional.get();
        Papel[] papel = mentor.getPapel();
        if (papel.length == 1 && papel[0] == Papel.MENTORADO) {
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

    public ResponseEntity<?> comprarCurso(ComprarCursoRequest request, String token) {
        String jwtToken = token.replace("Bearer ", "");
        String jwtEmail = jwtService.extractEmail(jwtToken);

        Usuario mentorado = usuarioRepository.findById(request.getIdMentorado())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (!jwtEmail.equals(mentorado.getEmail())) {
            return ResponseEntity.status(404).body("Token invalido ou expirado!");
        }

        Curso curso = cursoRepository.findByTitulo(request.getTitulo());

        Usuario mentor = usuarioRepository.findByCpf(curso.getCpfMentor())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        mentorado.setSaldo(mentorado.getSaldo().subtract(curso.getPreco()));

        if (!mentorado.getCursos().contains(curso)) {
            mentorado.getCursos().add(curso);
        }
        if (mentorado.getSaldo().compareTo(curso.getPreco()) < 0) {
            return ResponseEntity.status(400).body("Saldo insuficiente para realizar a compra do curso | " + request.getTitulo());
        }

        if (curso.getQuantidadeAluno() <= 0) {
            return ResponseEntity.status(400).body("Quantidade de alunos indisponivel para o curso | " + request.getTitulo());
        }

        mentor.setSaldo(mentor.getSaldo().add(curso.getPreco()));
        curso.setQuantidadeAluno(curso.getQuantidadeAluno() - 1);

        Map<String, Curso> cursosMentor = mentor.getCursos().stream()
                .collect(Collectors.toMap(Curso::getId, c -> c));
        cursosMentor.put(curso.getId(), curso);
        mentor.setCursos(new ArrayList<>(cursosMentor.values()));

        usuarioRepository.save(mentorado);
        usuarioRepository.save(mentor);
        cursoRepository.save(curso);

        return ResponseEntity.status(200).body("Compra do curso | " + request.getTitulo() + " | realizada com sucesso");
    }
}
