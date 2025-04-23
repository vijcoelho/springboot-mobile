package br.com.mentoria.projeto.dto.request.usuario;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ColocarSaldoUsuarioRequest {
    private String id;
    private BigDecimal saldo;
}
