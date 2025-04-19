package br.com.mentoria.projeto.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Builder
@Data
public class Mentorado {
    @Id
    private String id;
    @NotBlank
    private String nome;
    @NotBlank
    @Indexed(unique = true)
    private String email;
    @NotNull
    @Indexed(unique = true)
    private String cpf;
    @NotBlank
    private String senha;
    @NotBlank
    private String sobreMim;
}
