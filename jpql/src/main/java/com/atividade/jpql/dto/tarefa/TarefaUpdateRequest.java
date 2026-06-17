package com.atividade.jpql.dto.tarefa;

import java.math.BigDecimal;

public record TarefaUpdateRequest(
        String titulo,
        String codigo,
        BigDecimal custo
) {
}
