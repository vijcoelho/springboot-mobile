package br.com.mentoria.projeto.dto.request.usuario;

import lombok.Data;

@Data
public class LoginUsuarioRequest {
    private String email;
    private String senha;
}
