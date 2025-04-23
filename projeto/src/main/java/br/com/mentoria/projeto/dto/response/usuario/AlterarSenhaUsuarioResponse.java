package br.com.mentoria.projeto.dto.response.usuario;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlterarSenhaUsuarioResponse {
    private String id;
    private String mensagem;
}
