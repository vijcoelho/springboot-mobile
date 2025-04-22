package br.com.mentoria.projeto.dto.response;

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
