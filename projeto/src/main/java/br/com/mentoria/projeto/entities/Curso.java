package br.com.mentoria.projeto.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Builder
@Data
public class Curso {
    @Id
    private String id;
    @NotBlank
    private String nomeCurso;
    @NotBlank
    private String descricao;
    private LocalDate dataCriacao;
    @NotNull
    private Double preco;
    @NotNull
    private Integer quantidadeAlunos;

}
