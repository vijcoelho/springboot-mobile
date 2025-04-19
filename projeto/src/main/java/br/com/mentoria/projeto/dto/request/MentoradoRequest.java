package br.com.mentoria.projeto.dto.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MentoradoRequest {
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String sobreMim;
}
