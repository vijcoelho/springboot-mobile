package br.com.mentoria.projeto.dto.response.usuario;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUsuarioResponse {
    private String id;
    private String mensagem;
    private String token;
}
