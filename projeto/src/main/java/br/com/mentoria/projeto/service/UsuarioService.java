package br.com.mentoria.projeto.service;

import br.com.mentoria.projeto.dto.request.AlterarSenhaUsuarioRequest;
import br.com.mentoria.projeto.dto.request.CriarUsuarioRequest;
import br.com.mentoria.projeto.dto.response.AlterarSenhaUsuarioResponse;
import br.com.mentoria.projeto.entity.Usuario;
import br.com.mentoria.projeto.mapper.UsuarioMapper;
import br.com.mentoria.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioMapper usuarioMapper;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<?> cadastro(CriarUsuarioRequest request) {
        Usuario usuario = usuarioMapper.entidadeCadastro(request);
        if (usuario != null) {
            usuario.setSenha(passwordEncoder.encode(request.getSenha()));
            usuarioRepository.save(usuario);
            return ResponseEntity.status(200).body("Usuario salvo com sucesso");
        }
        return ResponseEntity.status(400).body("Nao foi possivel salver usuario");
    }

    public AlterarSenhaUsuarioResponse alterarSenha(AlterarSenhaUsuarioRequest request, String id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar usuario"));

        usuario.setSenha(passwordEncoder.encode(request.getNovaSenha()));
        usuarioRepository.save(usuario);

        return AlterarSenhaUsuarioResponse.builder()
                .id(usuario.getId())
                .mensagem("Senha alterada com sucesso!")
                .build();
    }

    public List<Usuario> pegarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> pegarPeloId(String id) {
        return usuarioRepository.findById(id);
    }
}
