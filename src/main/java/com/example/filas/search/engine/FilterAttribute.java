package com.example.filas.search.engine;

import java.util.Arrays;

public enum FilterAttribute {

    ORIGEM("origem"),
    FILA_ATUAL("filaAtual"),
    PERFIL("perfil"),
    CLIENTE_CPF("clienteCpf"),
    GRUPO2("grupo2"),
    AGENTE_NOME("agenteNome"),
    AGENTE_CODIGO("agenteCodigo"),
    CIDADE("cidade"),
    LOJISTA_NOME("lojistaNome"),
    TIPO_CLIENTE("tipoCliente"),
    TIPO_LOJISTA("tipoLojista");

    private final String field;

    FilterAttribute(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public static FilterAttribute from(String value) {
        return Arrays.stream(values())
                .filter(v -> v.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Filtro inválido: " + value)
                );
    }
}
