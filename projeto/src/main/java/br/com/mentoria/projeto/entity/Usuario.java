package br.com.mentoria.projeto.entity;
import br.com.mentoria.projeto.entity.enums.Papel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@Document(collection = "usuarios")
public class Usuario {
    @Id
    private String id;
    @NotBlank
    private String nome;
    @NotBlank
    @Indexed(unique = true)
    private String email;
    @NotBlank
    private String senha;
    @NotBlank
    @Indexed(unique = true)
    private String cpf;
    @Builder.Default
    private List<Curso> cursos = new ArrayList<>();
    @NotBlank
    private String sobreMim;
    @NotNull
    private Papel papel;
    @Builder.Default
    private BigDecimal saldo = BigDecimal.valueOf(0.0);
    @Builder.Default
    private Boolean status = true;
}
