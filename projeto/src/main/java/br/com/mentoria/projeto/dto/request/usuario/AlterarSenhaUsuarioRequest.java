package br.com.mentoria.projeto.dto.request.usuario;

import lombok.Data;

@Data
public class AlterarSenhaUsuarioRequest {
    private String senhaAtual;
    private String novaSenha;
}
