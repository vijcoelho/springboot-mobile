package br.com.mentoria.projeto.ia;

import br.com.mentoria.projeto.entity.Curso;
import br.com.mentoria.projeto.entity.enums.Papel;
import br.com.mentoria.projeto.repository.CursoRepository;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class GeminiService {
    @Autowired
    private CursoRepository cursoRepository;

    private final String apiKey;
    private final RestTemplate restTemplate;

    public GeminiService() {
        Dotenv dotenv = Dotenv.load();
        this.apiKey = dotenv.get("GEMINI_API_KEY");
        this.restTemplate = new RestTemplate();
    }

    public String recomendarCursos(String sobreMim, Papel[] papel) {
        List<Curso> cursos = cursoRepository.findAll();
        String cursosTexto = cursos.stream()
                .map(c -> String.format("- Título: %s | Descrição: %s | Preço: R$ %.2f",
                        c.getTitulo(), c.getDescricao(), c.getPreco()))
                .collect(Collectors.joining("\n"));

        String prompt = String.format("""
            Papel: %s
            Sobre mim: %s

            Abaixo está uma lista de cursos disponíveis:
            %s

            Com base nessa lista, recomende todos os cursos possiveis e para cada um, me retorne:
            - Título do curso
            - Descrição
            - Preço
            - Justificativa da IA para recomendar esse curso

            Formate a resposta em JSON com a seguinte estrutura:
            {
              "recomendacoes": [
                {
                  "titulo": "...",
                  "descricao": "...",
                  "preco": "...",
                  "justificativa": "..."
                }
              ]
            }
            """, papel, sobreMim, cursosTexto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestBody = new HashMap<>();
        Map<String, Object> contents = new HashMap<>();
        contents.put("parts", new Object[] { Map.of("text", prompt) });
        requestBody.put("contents", new Object[] { contents });

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, httpHeaders);
        String apiUrl = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + apiKey;
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, request, String.class);

        return response.getBody();
    }

}
