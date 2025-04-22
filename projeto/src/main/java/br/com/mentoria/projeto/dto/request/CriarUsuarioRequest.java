package br.com.mentoria.projeto.dto.request;

import br.com.mentoria.projeto.entity.enums.Papel;
import lombok.Data;

@Data
public class CriarUsuarioRequest {
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private Papel papel;
    private String sobreMim;
}
