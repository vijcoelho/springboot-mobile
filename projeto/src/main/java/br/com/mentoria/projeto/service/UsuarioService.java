package br.com.mentoria.projeto.service;

import br.com.mentoria.projeto.dto.request.AlterarSenhaUsuarioRequest;
import br.com.mentoria.projeto.dto.request.CriarUsuarioRequest;
import br.com.mentoria.projeto.dto.response.AlterarSenhaUsuarioResponse;
import br.com.mentoria.projeto.entity.Usuario;
import br.com.mentoria.projeto.ia.GeminiService;
import br.com.mentoria.projeto.mapper.UsuarioMapper;
import br.com.mentoria.projeto.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;
    private final GeminiService geminiService;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(
            UsuarioMapper usuarioMapper,
            UsuarioRepository usuarioRepository,
            GeminiService geminiService,
            PasswordEncoder passwordEncoder
    ) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;
        this.geminiService = geminiService;
        this.passwordEncoder = passwordEncoder;
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

    public ResponseEntity<?> recomendacoes(String id) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    String respostaBruta = geminiService.recomendarCursos(usuario.getSobreMim(), usuario.getPapel());
                    String jsonLimpo = extrairJsonLimpo(respostaBruta);

                    try {
                        ObjectMapper mapper = new ObjectMapper();
                        JsonNode respostaJson = mapper.readTree(jsonLimpo);

                        Map<String, Object> responseMap = new HashMap<>();
                        responseMap.put("usuario", usuario.getId());
                        responseMap.put("resposta", respostaJson);

                        return ResponseEntity.ok(responseMap);

                    } catch (Exception e) {
                        e.printStackTrace();
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar resposta da IA.");
                    }
                })
                .orElseGet(() -> {
                    Map<String, Object> errorMap = new HashMap<>();
                    errorMap.put("error", "Usuário não encontrado");
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
                });
    }

    private String extrairJsonLimpo(String resposta) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(resposta);
            JsonNode candidates = root.path("candidates");
            if (!candidates.isEmpty()) {
                String texto = candidates.get(0).path("content").path("parts").get(0).path("text").asText();
                int start = texto.indexOf("{");
                int end = texto.lastIndexOf("}") + 1;
                if (start >= 0 && end > start) {
                    String jsonLimpo = texto.substring(start, end);
                    Object jsonObject = mapper.readValue(jsonLimpo, Object.class);
                    return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resposta;
    }

}
