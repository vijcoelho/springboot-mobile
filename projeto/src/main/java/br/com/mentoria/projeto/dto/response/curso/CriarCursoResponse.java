package br.com.mentoria.projeto.dto.response.curso;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CriarCursoResponse {
    private String id;
    private String titulo;
    private String descricao;
    private String mensagem;
}
