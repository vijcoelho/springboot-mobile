package br.com.mentoria.projeto.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
@Builder
@Data
public class Curso {
    @Id
    private String id;
    @NotNull
    private String cpfMentor;
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @NotNull
    private BigDecimal preco;
    @NotNull
    private Integer quantidadeAluno;
}
