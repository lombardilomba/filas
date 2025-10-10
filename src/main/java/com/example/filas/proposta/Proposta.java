package com.example.filas.proposta;

import java.math.BigDecimal;

public record Proposta(
        String id,
        String cpf,
        BigDecimal valorSolicitado
) {
}
