package br.com.mentoria.projeto.entities;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

@Builder
@Data
public class Mentor {
    @Id
    private String id;
    @NotBlank
    private String nome;
    @NotBlank
    @Indexed(unique = true)
    private String email;
    @NotBlank
    @Indexed(unique = true)
    private String cpf;
    private List<Curso> cursos;
}
