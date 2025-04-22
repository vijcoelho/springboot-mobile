package br.com.mentoria.projeto.dto.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class CriarCursoRequest {
    private String cpfMentor;
    private String titulo;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidadeAluno;
}
